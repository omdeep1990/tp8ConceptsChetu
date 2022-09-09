package com.chetu.demotp8;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.chetu.demotp8.databinding.ActivityDateTimePickerBinding;

import java.util.Calendar;

public class DateTimePickerActivity extends AppCompatActivity {
    private ActivityDateTimePickerBinding binding;
    private Calendar calendar;
    private int DAY, MONTH, YEAR;
    private String[] weekName = {"Saturday", "Sunday", "Monday", "Tuesday","WEDNESDAY", "THURSDAY", "FRIDAY",};
    private String[] monthName = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    private int SECONDS, MINUTES, HOURS, DATE, DAY_OF_WEEK, MONTH_NAME, AM, PM, AM_PM;

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
        DATE = calendar.get(Calendar.SATURDAY);
        DAY_OF_WEEK = calendar.get(Calendar.DAY_OF_WEEK);
        MONTH_NAME = calendar.get(Calendar.MONTH);
        AM_PM = calendar.get(Calendar.AM_PM);
//        AM = calendar.get(Calendar.AM);
//        PM = calendar.get(Calendar.PM);

        binding.showTesting.setText(weekName[DAY_OF_WEEK]+","+" "+monthName[MONTH_NAME]+" "+DAY);
//        TIME = calendar.get(Calendar.TUESDAY);

        binding.showDate.setText(DAY+"/"+(MONTH+1)+"/"+YEAR+"\n"+ DATE+ AM+" "+PM);

        binding.datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(DateTimePickerActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int dayOfMonth, int month, int year) {
                        binding.showDate.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                    }
                }, YEAR, MONTH, DAY);
                datePickerDialog.show();
            }
        });

        //TODO: 2. To Show Time Using Time Picker Dialog: -
        SECONDS = calendar.get(Calendar.SECOND);
        MINUTES = calendar.get(Calendar.MINUTE);
        HOURS = calendar.get(Calendar.HOUR);

        binding.showTime.setText(HOURS+":"+MINUTES+":"+SECONDS);

        binding.timePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(DateTimePickerActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hours, int minutes) {
                        if(AM_PM == Calendar.AM){
                            // AM
                            binding.showTime.setText(hours+":"+minutes+""+"AM");
                        }else if (AM_PM == Calendar.PM){
                            // PM
                            binding.showTime.setText(hours+":"+minutes+""+"PM");
                        }
//                        binding.showTime.setText(hours+":"+minutes+""+AM_PM);


//                        String AM_PM;
//                    if (hourOfDay>=0&&hourOfDay<12){
//                        AM_PM=" AM";
//                    }else {
//                        AM_PM=" PM";
//                    }
//                    selectTime.setText ( hourOfDay + ":" + minute+""+AM_PM );
                    }
                }, HOURS, MINUTES, false);
                timePickerDialog.show();
            }
        });
    }
}