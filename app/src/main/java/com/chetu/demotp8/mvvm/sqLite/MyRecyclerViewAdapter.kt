package com.chetu.demotp8.mvvm.sqLite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.chetu.demotp8.R
import com.chetu.demotp8.databinding.DisplayUserDataBinding
import com.chetu.demotp8.javaConcepts.adapter.RecyclerViewAdapter
import com.chetu.demotp8.javaConcepts.adapter.RecyclerViewAdapter.MyViewHolder

class MyRecyclerViewAdapter(val list : List<PersonalData>) : RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>()/*,
    View.OnLongClickListener*/ {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding : DisplayUserDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.display_user_data, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val userList : PersonalData = list[position]
        holder.binding.fullName.text = userList.fName+" "+userList.lName
        holder.binding.mobileNo.text = userList.mobileNo
//        holder.binding.rootLayout.setOnLongClickListener(this)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MyViewHolder(var binding : DisplayUserDataBinding) : RecyclerView.ViewHolder(binding.root)

}