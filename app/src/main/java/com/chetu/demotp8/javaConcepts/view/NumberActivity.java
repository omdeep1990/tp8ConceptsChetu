package com.chetu.demotp8.javaConcepts.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.NumberPicker;

import com.chetu.demotp8.databinding.ActivityNumberBinding;
import com.chetu.demotp8.javaConcepts.utilities.Util;

public class NumberActivity extends AppCompatActivity {
    private ActivityNumberBinding binding;
    //TODO: 2.
    private String[] monthName = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNumberBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //TODO: 1. For Picking number only;
        binding.numberPicker.setMinValue(0);
        binding.numberPicker.setMaxValue(100);

        binding.numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int oldValue, int newValue) {
                binding.showNumber.setText("Current Value : "+String.valueOf(numberPicker.getValue())+"\n"+
                        "Old Value :"+String.valueOf(oldValue)+"\n"+
                        "New Value :"+String.valueOf(newValue));
            }
        });


        //TODO: 2. Month Name Picker from the given Array: -
        binding.monthPicker.setMinValue(0);
        binding.monthPicker.setMaxValue(11);
        binding.monthPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int oldValue, int newValue) {
                binding.showMonth.setText("Current Value : "+monthName[numberPicker.getValue()]+"\n"+
                        "Old Value :"+monthName[oldValue]+"\n"+
                        "New Value :"+monthName[newValue]);

                Util.customToast(NumberActivity.this, "Custom Toast Invoked From Number Activity");
                Util.customToast("Simple Toast Called", NumberActivity.this);
            }
        });
    }
}