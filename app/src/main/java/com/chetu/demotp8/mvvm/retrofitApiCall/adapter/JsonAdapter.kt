package com.chetu.demotp8.mvvm.retrofitApiCall.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.chetu.demotp8.R
import com.chetu.demotp8.databinding.DisplayApiDataDemoBinding
import com.chetu.demotp8.mvvm.retrofitApiCall.model.AlbumsItem

class JsonAdapter(private val list : List<AlbumsItem>) : RecyclerView.Adapter<JsonAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding : DisplayApiDataDemoBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.display_api_data_demo, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val myList : AlbumsItem = list[position]
        holder.binding.id.text = myList.id.toString()
        holder.binding.title.text = myList.title
        holder.binding.userId.text = myList.userId.toString()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MyViewHolder(var binding : DisplayApiDataDemoBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}