package com.example.androidproject.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidproject.domain.items.ItemsInteractor
import com.example.androidproject.domain.model.ItemsModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SearchViewModel @Inject constructor(
    private val itemsInteractor: ItemsInteractor
): ViewModel() {

    private val _items = MutableLiveData<ItemsModel>()
    val items: LiveData<ItemsModel> = _items

    fun findItem(searchText:String){
        viewModelScope.launch {
           val foundItems =itemsInteractor.findItem(searchText)
            //_items.value = foundItems
        }
    }
}