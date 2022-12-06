package com.sultan.aidanashop.presentation.adapter

import androidx.recyclerview.widget.DiffUtil.ItemCallback
import com.sultan.aidanashop.domain.ShopItem

class ShopItemCallBack : ItemCallback<ShopItem>() {
    override fun areItemsTheSame(oldItem: ShopItem, newItem: ShopItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ShopItem, newItem: ShopItem): Boolean {
        return oldItem == newItem
    }
}