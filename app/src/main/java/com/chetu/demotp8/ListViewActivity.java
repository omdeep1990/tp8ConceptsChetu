package com.chetu.demotp8;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.chetu.demotp8.databinding.ActivityListViewBinding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {
    private ActivityListViewBinding binding;
    //TODO: Serializable-->
    ArrayList<String> myList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //TODO: Serializable--> For receiving the data by using serializable User Type: -
//        myList = (ArrayList<String>) getIntent().getSerializableExtra("user_List");
//        CustomListAdapter customListAdapter = new CustomListAdapter(this, myList);
//        Log.d("myList", myList.toString());

        ArrayList<User> userArrayList = new Gson().fromJson(getIntent().getStringExtra("user_List"),
                new TypeToken<ArrayList<User>>(){}.getType());
        CustomListAdapter customListAdapter = new CustomListAdapter(this, userArrayList);
        binding.listView.setAdapter(customListAdapter);


    }
}