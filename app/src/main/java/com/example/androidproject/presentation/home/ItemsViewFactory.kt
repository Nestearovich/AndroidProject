package com.example.androidproject.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidproject.domain.items.ItemsInteractor


class ItemsViewFactory(
    private val itemsInteractor: ItemsInteractor
 ) : ViewModelProvider.Factory {
    override fun <T : ViewModel>create(modelClass: Class<T>): T{
        return ItemsViewModel(itemsInteractor) as T
    }
}