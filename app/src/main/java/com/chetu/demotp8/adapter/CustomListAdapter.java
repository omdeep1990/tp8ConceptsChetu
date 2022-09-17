package com.chetu.demotp8.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.chetu.demotp8.R;
import com.chetu.demotp8.interf.OnItemClickListener;
import com.chetu.demotp8.model.User;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

public class CustomListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<User> userArrayList;
    private OnItemClickListener onItemClickListener;

    public CustomListAdapter(Context context, ArrayList<User> userArrayList, OnItemClickListener onItemClickListener) {
        this.context = context;
        this.userArrayList = userArrayList;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public int getCount() {
        return userArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.layout_list_view_data, viewGroup, false);
        MaterialTextView tvFname = view.findViewById(R.id.first_name);
        MaterialTextView tvLName = view.findViewById(R.id.last_name);
        MaterialTextView tvMobileNo = view.findViewById(R.id.mobile_no);

        tvFname.setText(userArrayList.get(position).getFirstName());
        tvLName.setText(userArrayList.get(position).getLastName());
        tvMobileNo.setText(userArrayList.get(position).getMobileNo());

        //TODO: Similarly we can setOn click listener on any view of the viewGroup: -
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(position, userArrayList.get(position));
            }
        });
        return view;
    }
}
