package com.example.androidproject.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidproject.R
import com.example.androidproject.domain.items.ItemsInteractor
import com.example.androidproject.domain.model.ItemsModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemsViewModel @Inject constructor(
    private val itemsInteractor: ItemsInteractor,
) : ViewModel() {

    private val _items = MutableLiveData<List<ItemsModel>>()
    val items: LiveData<List<ItemsModel>> = _items

    private val _msg = MutableLiveData<Int>()
    val msg: LiveData<Int> = _msg

    private val _bundle = MutableLiveData<NavigateWithBundle?>()
    val bundle: LiveData<NavigateWithBundle?> = _bundle


    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun getData() {
        viewModelScope.launch {
            try {
                itemsInteractor.getData()
                val listItems = itemsInteractor.showData()
               _items.value = listItems
            } catch (e: java.lang.Exception) {
                _error.value = e.message.toString()
            }
        }
    }

    fun imageViewClicked() {
        _msg.value = R.string.imageView_clicked
    }

    fun elementClicked(description: String, image: String) {
        _bundle.value = NavigateWithBundle(
            description , image,  R.id.action_itemsFragment_to_detailFragment
        )
    }
    fun userNavigated() {
        _bundle.value = null
    }

    fun deleteItem(description: String){
        viewModelScope.launch {  itemsInteractor.deleteItemByDescription(description)}

    }
}

data class NavigateWithBundle(
    val image: String,
    val description: String,
    val destinationId: Int
)
