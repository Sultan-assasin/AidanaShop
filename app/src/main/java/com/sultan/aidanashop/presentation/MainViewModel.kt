package com.sultan.aidanashop.presentation

import androidx.lifecycle.ViewModel
import com.sultan.aidanashop.data.ShopListRepositoryImpl
import com.sultan.aidanashop.domain.*

class MainViewModel : ViewModel() {
    private val repository = ShopListRepositoryImpl


    private val getShopListUseCase = GetShopListUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

}