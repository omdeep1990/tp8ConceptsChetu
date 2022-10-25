package com.chetu.demotp8.mvvm.roomDb

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.chetu.demotp8.R
import com.chetu.demotp8.databinding.LayoutListItemsBinding

class MyRecyclerViewAdapter(private val userList : List<User>, private val clickListener : (User) -> Unit) : RecyclerView.Adapter<MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflator = LayoutInflater.from(parent.context)
        val binding : LayoutListItemsBinding = DataBindingUtil.inflate(layoutInflator, R.layout.layout_list_items, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(userList[position], clickListener)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

}

class MyViewHolder(val binding : LayoutListItemsBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(user: User, clickListener : (User) -> Unit){
        binding.tvFname.text = user.fistName
        binding.tvLname.text = user.lastName
        binding.tvMobile.text = user.mobilNo

        binding.listItem.setOnClickListener {
            clickListener(user)
        }
    }
}