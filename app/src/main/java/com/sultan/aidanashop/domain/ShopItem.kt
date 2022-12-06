package com.sultan.aidanashop.domain

data class ShopItem(
    val name: String,
    val price: Int,
    val image: Int,
    val title: String,
    var id: Int = UNDEFINED_ID
){
    companion object{
        const val UNDEFINED_ID  = -1
    }
}