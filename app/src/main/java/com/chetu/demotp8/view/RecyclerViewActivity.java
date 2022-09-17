package com.chetu.demotp8.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.chetu.demotp8.R;
import com.chetu.demotp8.adapter.RecyclerViewAdapter;
import com.chetu.demotp8.databinding.ActivityRecyclerViewBinding;
import com.chetu.demotp8.interf.OnItemClickListener;
import com.chetu.demotp8.model.User;
import com.chetu.demotp8.utilities.Util;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {
    private ActivityRecyclerViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRecyclerViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<User> userArrayList = new Gson().fromJson(getIntent().getStringExtra("user_List"),
                new TypeToken<ArrayList<User>>(){}.getType());

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, userArrayList, new OnItemClickListener() {
            @Override
            public void onItemClick(int position, User user) {
                Util.customToast(RecyclerViewActivity.this, userArrayList.get(position).getFirstName()+" "+ userArrayList.get(position).getLastName());
            }
        });

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}