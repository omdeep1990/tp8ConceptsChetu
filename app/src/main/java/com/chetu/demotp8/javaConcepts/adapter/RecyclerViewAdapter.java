package com.chetu.demotp8.javaConcepts.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chetu.demotp8.R;
import com.chetu.demotp8.javaConcepts.interf.OnItemClickListener;
import com.chetu.demotp8.javaConcepts.model.User;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<User> userList;
    private OnItemClickListener onItemClickListener;

    public RecyclerViewAdapter(Context context, ArrayList<User> userList, OnItemClickListener onItemClickListener) {
        this.context = context;
        this.userList = userList;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_list_view_data, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        User user = userList.get(position);
        holder.firstName.setText(user.getFirstName());
        holder.lastName.setText(user.getLastName());
        holder.mobileNo.setText(user.getMobileNo());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(position, userList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private MaterialTextView firstName, lastName, mobileNo;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            firstName = itemView.findViewById(R.id.first_name);
            lastName = itemView.findViewById(R.id.last_name);
            mobileNo = itemView.findViewById(R.id.mobile_no);

        }
    }
}
