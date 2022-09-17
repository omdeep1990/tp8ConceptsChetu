package com.chetu.demotp8.utilities;

import android.app.Activity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.chetu.demotp8.R;

public class Util {

    public static void customToast(Activity activity, String msg) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_custom_toast, activity.findViewById(R.id.root_layout));
        TextView textView = view.findViewById(R.id.show_toast);
        textView.setText(msg);

        Toast toast = new Toast(activity);
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(view);
        toast.show();
    }

    public static void customToast(String msg, Activity activity) {
        Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show();
    }
}
