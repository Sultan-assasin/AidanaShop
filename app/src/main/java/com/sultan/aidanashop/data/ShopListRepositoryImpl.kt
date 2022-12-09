package com.sultan.aidanashop.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sultan.aidanashop.R
import com.sultan.aidanashop.domain.ShopItem
import com.sultan.aidanashop.domain.ShopListRepository

object ShopListRepositoryImpl: ShopListRepository {

//    private val shopList = MutableLiveData<List<ShopItem>>()
//
//    private lateinit var shopItem: ShopItem
//    private val coroutineScope = CoroutineScope(Dispatchers.Main)
//
//    override suspend fun getShopItem(key: String): ShopItem {
//        coroutineScope.launch {
//            FirebaseDatabase.getInstance()
//                .getReference("ShpItem")
//                .addListenerForSingleValueEvent(object : ValueEventListener {
//                    override fun onDataChange(snapshot: DataSnapshot) {
//                        if (snapshot.exists()) {
//                            for (shopItemSnapshot in snapshot.children) {
//                                shopItem = snapshot.getValue(ShopItem::class.java)!!
//                                shopItem.key = shopItemSnapshot.key.toString()
//                                if (shopItem.key == key) {
//                                    shopItem = shopItemSnapshot as ShopItem
//                                    updateFirebase(shopItem)
//                                }
//                            }
//                        }
//                    }
//
//                    override fun onCancelled(error: DatabaseError) {
//                        Log.d("Error", "ShopLIstRepositoryImpl error $error")
//                    }
//
//                })
//        }
//        return shopItem
//    }
//
//    override suspend fun deleteShopItem(shopItem: ShopItem) {
//        TODO("if i use this code I am finished")
////        var shop : ShopItem
////        getShopList().observeForever { data ->
////            if (shopItem == data) {
////                shop = shopItem
////               // shopList.
//        //updateFirebase(shopItem)
////                }
////            }
//    }
//
//
//    override fun getShopList(): MutableLiveData<List<ShopItem>> {
//        FirebaseDatabase.getInstance()
//            .getReference("ShpItem")
//            .addListenerForSingleValueEvent(object : ValueEventListener {
//                override fun onDataChange(snapshot: DataSnapshot) {
//                    if (snapshot.exists()) {
//                        for (shopItemSnapshot in snapshot.children) {
//                            val shopItem = snapshot.getValue(ShopItem::class.java)
//                            shopItem!!.key = shopItemSnapshot.key.toString()
//                            shopList.postValue(listOf(shopItem))
//                        }
//                    }
//                }
//
//                override fun onCancelled(error: DatabaseError) {
//                    Log.d("Error", "ShopLIstRepositoryImpl error $error")
//                }
//
//            })
//        return shopList
//    }
//    private fun updateFirebase(shopItem: ShopItem) {
//        FirebaseDatabase.getInstance().getReference("Cart").child("UNIQUE_USER_ID")
//            .child(shopItem.key).setValue(shopItem)
//            .addOnSuccessListener { Log.d("success" , "Success") }
//    }


    //создаем их и здесь же иницализирвуем
    // завтра сделаем и запускаем что бы все показалось и будет легче создаватть программно чем базы данных
    private val shopListLD = MutableLiveData<List<ShopItem>>()

    private val shopList  = sortedSetOf<ShopItem>({ p0, p1 -> p0.id.compareTo(p1.id) }) // сортировка по id

    private var autoIncrementId = 0

    //   что бы все методы работали и добавились данные вызываем init

    init {
            addShopItem(ShopItem("Burger", 0,R.drawable.img,"Burger", 1))
            addShopItem(ShopItem("Pizza", 0,R.drawable.img,"Pizza", 2))
            addShopItem(ShopItem("Chicken", 0,R.drawable.img,"Chicken", 3))
            addShopItem(ShopItem("Drinks", 0,R.drawable.img,"Drinks", 4))
            addShopItem(ShopItem("Sushi", 0,R.drawable.img,"Sushi", 5))
        }
    override fun addShopItem(shopItem: ShopItem) {
        if(shopItem.id == ShopItem.UNDEFINED_ID){
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
        updateList()
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
        updateList()
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldElement = getShopItem(shopItem.id)
        shopList.remove(oldElement)
        addShopItem(shopItem)


    }

    override fun getShopItem(shopItemId: Int): ShopItem {
        return shopList.find {
            it.id == shopItemId
        } ?: throw  RuntimeException("Element with $shopItemId not found")
    }

    override fun getShopList(): LiveData<List<ShopItem>> {
        return shopListLD
    }
    private fun updateList(){
        shopListLD.value = shopList.toList()
    }
}