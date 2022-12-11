package com.example.androidproject.domain

import com.example.androidproject.model.ItemsModel

class ItemsInteractor(private val itemsRepository: ItemsRepository) {

    fun getData():List<ItemsModel> {
       return itemsRepository.getData()
    }
}