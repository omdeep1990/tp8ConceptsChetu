package com.chetu.demotp8;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.chetu.demotp8.databinding.ActivityListViewBinding;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {
    private ActivityListViewBinding binding;
    ArrayList<String> myList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        myList = (ArrayList<String>) getIntent().getSerializableExtra("user_List");

    }
}