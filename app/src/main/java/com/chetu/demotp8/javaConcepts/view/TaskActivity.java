package com.chetu.demotp8.javaConcepts.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.chetu.demotp8.R;
import com.chetu.demotp8.databinding.ActivityTaskBinding;
import com.chetu.demotp8.javaConcepts.utilities.Util;

public class TaskActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityTaskBinding binding;
    private String[] PERMISSIONS = new String[]{Manifest.permission.CALL_PHONE, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION};
    private String tel = "tel:", Phone, mobileNo="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTaskBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.dialBtn.setOnClickListener(this);
        binding.callBtn.setOnClickListener(this);
        binding.selectNo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        Phone = "";
        mobileNo = "";
        switch (view.getId()) {
            case R.id. dial_btn:
                Phone = binding.selectNo.getText().toString();
                if (Phone.isEmpty()) {
                    Util.customToast(this, "Please Enter Your Mobile Number");
                    return;
                }
                else {
                    mobileNo += tel+Phone;
                }
                Intent intentDial = new Intent(Intent.ACTION_DIAL);
                intentDial.setData(Uri.parse(mobileNo));
                //TODO: OR: -
//                intentDial.setData(Uri.parse("tel:"+Phone));
                startActivity(intentDial);
                Phone=" ";
                break;
            case R.id.call_btn:
                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    doCall();
                } else {
                    ActivityCompat.requestPermissions(TaskActivity.this, PERMISSIONS, 1);
                }
                break;
        }
    }
    private void doCall() {
        Phone = binding.selectNo.getText().toString();
        if (Phone.isEmpty()) {
            Util.customToast(this, "Please Enter Your Mobile Number");
            return;
        }
        //TODO: Second method to concatenate string: -
        Intent intentCall = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+Phone));
        startActivity(intentCall);
        Phone=" ";
    }
}