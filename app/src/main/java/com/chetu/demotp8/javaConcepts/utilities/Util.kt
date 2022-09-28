package com.chetu.demotp8.javaConcepts.utilities

import android.app.Activity
import android.view.LayoutInflater
import com.chetu.demotp8.R
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import android.view.Gravity

object Util {
    @JvmStatic
    fun customToast(activity: Activity, msg: String?) {
        val inflater = activity.layoutInflater
        val view =
            inflater.inflate(R.layout.layout_custom_toast, activity.findViewById(R.id.root_layout))
        val textView = view.findViewById<TextView>(R.id.show_toast)
        textView.text = msg
        val toast = Toast(activity)
        toast.setGravity(Gravity.BOTTOM, 0, 0)
        toast.duration = Toast.LENGTH_LONG
        toast.view = view
        toast.show()
    }

    @JvmStatic
    fun customToast(msg: String?, activity: Activity?) {
        Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show()
    }
}