package com.chetu.demotp8.kotlinConcepts

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.RemoteViews
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.databinding.DataBindingUtil
import com.chetu.demotp8.R
import com.chetu.demotp8.databinding.ActivityShowNotificationsBinding

class ShowNotificationsActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding : ActivityShowNotificationsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_show_notifications)

        binding.showNotification.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view!!.id) {
            R.id.show_notification -> {
                showNotification()
            }
        }
    }

    private fun showNotification() {
        val channelId = "10000"
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        //TODO: Used for custom notification: -
        val contentView = RemoteViews(packageName, R.layout.custom_notification_layout)
        contentView.setTextViewText(R.id.notification_body, "My Custom Notification")
        contentView.setTextViewText(R.id.notification_description, "Notification Body")


        val  builder = NotificationCompat.Builder(applicationContext, channelId)
            .setSmallIcon(R.drawable.notification)
                //TODO: Used for default notification: -
//            .setContentTitle("My Custom Notification")
//            .setContentText("Body Of Notification")

            .setCustomContentView(contentView)

        builder.setContent(contentView)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId, "Custom Notification", NotificationManager.IMPORTANCE_DEFAULT)
            channel.lockscreenVisibility
            channel.enableVibration(true)
            notificationManager.createNotificationChannel(channel)
            builder.setChannelId(channelId)
        }
        val notification = builder.build()
        notification.flags = notification.flags or Notification.FLAG_AUTO_CANCEL
        notificationManager.notify(1000, notification)
    }
}