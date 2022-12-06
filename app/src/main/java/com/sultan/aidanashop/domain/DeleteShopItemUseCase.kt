package com.sultan.aidanashop.domain

class DeleteShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun deleteShopList(shopItem: ShopItem) {
        shopListRepository.deleteShopItem(shopItem)
    }
}