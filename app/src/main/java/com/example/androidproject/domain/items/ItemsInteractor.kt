package com.example.androidproject.domain.items

import com.example.androidproject.domain.model.FavoritesModel
import com.example.androidproject.domain.model.ItemsModel
import javax.inject.Inject

class ItemsInteractor @Inject constructor(
    private val itemsRepository: ItemsRepository
) {

   suspend fun getData() {
         itemsRepository.getData()
    }

    suspend fun showData(): List<ItemsModel>{
        return itemsRepository.showData()
    }

    suspend fun deleteItemByDescription(description:String){
        itemsRepository.deleteItemByDescription(description)
    }

    suspend fun findItem(searchText: String):ItemsModel{
        return itemsRepository.findItemByDescription(searchText)
    }

    suspend fun onFavClicked(description: String){
        val foundItem =  itemsRepository.findItemByDescription(description)
        itemsRepository.favClicked(foundItem)
    }

    suspend fun getFavorites(): List<FavoritesModel>{
        return itemsRepository.getFavorites()
    }
}