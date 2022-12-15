package com.example.androidproject.presentation.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidproject.ItemsViewModel
import com.example.androidproject.domain.ItemsInteractor


class ItemsViewFactory(
    private val itemsInteractor: ItemsInteractor
 ) : ViewModelProvider.Factory {
    override fun <T : ViewModel>create(modelClass: Class<T>): T{
        return ItemsViewModel(itemsInteractor) as T
    }
}