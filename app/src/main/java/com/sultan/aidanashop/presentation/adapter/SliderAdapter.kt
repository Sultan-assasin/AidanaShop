package com.sultan.aidanashop.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.smarteist.autoimageslider.SliderViewAdapter
import com.sultan.aidanashop.databinding.SlideritemBinding

class SliderAdapter(image: ArrayList<String>) : SliderViewAdapter<SliderAdapter.Holder>() {

    class Holder(val binding: SlideritemBinding) :
        SliderViewAdapter.ViewHolder(binding.root)

    private var images : ArrayList<String> = image



    override fun getCount(): Int {
        return images.size
    }

    override fun onCreateViewHolder(parent: ViewGroup): Holder {
        val binding = SlideritemBinding.inflate(
            LayoutInflater.from(
                parent.context
            ), parent, false
        )
        return Holder(binding)
    }

    override fun onBindViewHolder(viewHolder: Holder, position: Int) {
        Glide.with(viewHolder.binding.image)
            .load(images.get(position)).fitCenter()
            .into(viewHolder.binding.image)
    }
}