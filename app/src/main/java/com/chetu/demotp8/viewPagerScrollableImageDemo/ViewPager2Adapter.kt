package com.chetu.demotp8.viewPagerScrollableImageDemo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.chetu.demotp8.R
import com.chetu.demotp8.databinding.ImagesHolderBinding

class ViewPager2Adapter(private val list : List<PagerImages>, private val context: Context) : RecyclerView.Adapter<ViewPager2Adapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding : ImagesHolderBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.images_holder, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val myList : PagerImages = list[position]
        holder.run {
            image.setImageDrawable(AppCompatResources.getDrawable(context, myList.image))
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
    inner class MyViewHolder(var binding : ImagesHolderBinding) : RecyclerView.ViewHolder(binding.root) {
        val image = binding.imageView
    }
}