package com.chetu.demotp8.javaConcepts.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.chetu.demotp8.databinding.ActivityDateTimePickerBinding;
import com.chetu.demotp8.databinding.LayoutRatingBarBinding;
import com.chetu.demotp8.javaConcepts.utilities.Util;

import java.util.Calendar;

public class DateTimePickerActivity extends AppCompatActivity {
    private ActivityDateTimePickerBinding binding;
    private Calendar calendar;
    private int DAY, MONTH, YEAR;
    private String[] weekName = {"", "Sunday", "Monday", "Tuesday","Wednesday", "Thursday", "Friday", "Saturday"};
    private String[] monthName = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    private int MILLI_SECONDS, SECONDS, MINUTES, HOURS, DATE, DAY_OF_WEEK, MONTH_NAME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDateTimePickerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        calendar = Calendar.getInstance();

        //TODO: 1. To Show Date Using Date Picker Dialog: -
        DAY = calendar.get(Calendar.DAY_OF_MONTH);
        MONTH = calendar.get(Calendar.MONTH);
        YEAR = calendar.get(Calendar.YEAR);
        DATE = calendar.get(Calendar.DATE);
        DAY_OF_WEEK = calendar.get(Calendar.DAY_OF_WEEK);
        MONTH_NAME = calendar.get(Calendar.MONTH);

        binding.showTesting.setText(weekName[DAY_OF_WEEK]+","+" "+monthName[MONTH_NAME]+" "+DAY);

        binding.showDate.setText(DAY+"/"+(MONTH+1)+"/"+YEAR+"\n");

        binding.datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(DateTimePickerActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        binding.showDate.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                    }
                }, YEAR, MONTH, DAY);
                datePickerDialog.show();
            }
        });

        //TODO: 2. To Show Time Using Time Picker Dialog: -
        MILLI_SECONDS = calendar.get(Calendar.MILLISECOND);
        SECONDS = calendar.get(Calendar.SECOND);
        MINUTES = calendar.get(Calendar.MINUTE);
        HOURS = calendar.get(Calendar.HOUR_OF_DAY);

        binding.showTime.setText(HOURS+":"+MINUTES+":"+SECONDS+":"+MILLI_SECONDS);

        binding.timePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(DateTimePickerActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hours, int minutes) {
                        String AM_PM;
                    if (hours >= 12){
                        AM_PM=" PM";
                    }else {
                        AM_PM=" AM";
                    }
                    binding.showTime.setText (hours + ":" + minutes+" "+AM_PM);
                    }
                }, HOURS, MINUTES, false);
                timePickerDialog.show();
            }
        });

        binding.ratingBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutRatingBarBinding barBinding = LayoutRatingBarBinding.inflate(getLayoutInflater());
                Dialog dialog = new Dialog(DateTimePickerActivity.this);
                dialog.setContentView(barBinding.getRoot());
                dialog.setCancelable(false);
                dialog.show();
                Window window = dialog.getWindow();
                window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

                barBinding.cancelRatingBar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                barBinding.showRatingBar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Util.customToast(DateTimePickerActivity.this, "Your Rating is: "+barBinding.ratingBar.getRating());
                        dialog.dismiss();

                    }
                });
            }
        });
    }
}