package com.example.androidproject.domain

import com.example.androidproject.model.ItemsModel

interface ItemsRepository {

    fun getData(): List<ItemsModel>
}