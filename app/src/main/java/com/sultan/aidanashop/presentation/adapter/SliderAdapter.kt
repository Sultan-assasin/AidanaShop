package com.sultan.aidanashop.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import androidx.viewpager2.widget.ViewPager2
import com.sultan.aidanashop.databinding.SlideItemContainerBinding
import com.sultan.aidanashop.domain.ShopItem

class SliderAdapter(private var list: List<ShopItem>, private var pager: ViewPager2) :
   RecyclerView.Adapter<SliderAdapter.SliderViewHolder>() {


    class SliderViewHolder(val binding: SlideItemContainerBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        val binding =
            SlideItemContainerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SliderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {

        holder.binding.imageSlide.setImageResource(list[position].image)

    }

    override fun getItemCount(): Int {
        return list.size
    }
}