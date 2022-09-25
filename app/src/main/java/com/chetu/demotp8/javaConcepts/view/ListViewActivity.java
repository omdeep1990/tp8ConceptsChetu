package com.chetu.demotp8.javaConcepts.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.chetu.demotp8.javaConcepts.adapter.CustomListAdapter;
import com.chetu.demotp8.javaConcepts.interf.OnItemClickListener;
import com.chetu.demotp8.javaConcepts.utilities.Util;
import com.chetu.demotp8.javaConcepts.model.User;
import com.chetu.demotp8.databinding.ActivityListViewBinding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {
    private ActivityListViewBinding binding;
    //TODO: Serializable-->
//    ArrayList<String> myList;

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
        CustomListAdapter customListAdapter = new CustomListAdapter(this, userArrayList, new OnItemClickListener() {
            @Override
            public void onItemClick(int position, User user) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+userArrayList.get(position).getMobileNo()));
                startActivity(intent);
                Util.customToast(ListViewActivity.this, userArrayList.get(position).getFirstName()+" "+ userArrayList.get(position).getLastName());
            }
        });
        binding.listView.setAdapter(customListAdapter);


    }
}