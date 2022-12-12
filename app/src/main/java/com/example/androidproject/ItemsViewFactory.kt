package com.example.androidproject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ItemsViewFactory(
    private val testParametr: TestParametr
 ) : ViewModelProvider.Factory {
    override fun <T : ViewModel>create(modelClass: Class<T>): T{
        return ItemsViewModel(testParametr) as T
    }
}