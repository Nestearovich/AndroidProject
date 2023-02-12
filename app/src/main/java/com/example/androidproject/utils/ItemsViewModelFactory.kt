package com.example.androidproject.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidproject.domain.items.ItemsInteractor
import com.example.androidproject.presentation.home.ItemsViewModel

class ItemsViewModelFactory (private val itemsInteractor: ItemsInteractor) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ItemsViewModel(itemsInteractor) as T
    }
}