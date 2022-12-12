package com.sultan.aidanashop.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintsChangedListener
import androidx.recyclerview.widget.ListAdapter
import com.sultan.aidanashop.R
import com.sultan.aidanashop.databinding.CategoryViewBinding
import com.sultan.aidanashop.domain.ShopItem
import java.lang.RuntimeException

class ShopItemAdapter :
    ListAdapter<ShopItem, ShopItemViewHolder>(ShopItemCallBack()) {


    var onShopItemClickListener: ((ShopItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {
        val binding =
            CategoryViewBinding.inflate(LayoutInflater.from(parent.context),
                parent,
                false)
        return ShopItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShopItemViewHolder, position: Int) {
        val shopItem = getItem(position)
        with(holder.binding) {
//            with(shopItem) {
//                Glide.with(context)
//                    .load(shopItem.image)
//                    .into(imageView) // set Image Drawable
            imageView.setImageResource(shopItem.image)
            textView.text = shopItem.name
            root.setOnClickListener {
                onShopItemClickListener?.invoke(shopItem)
            }
        }
    }
}
