package com.example.androidproject.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidproject.R
import com.example.androidproject.domain.items.ItemsInteractor
import com.example.androidproject.domain.model.ItemsModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject


class ItemsViewModel @Inject constructor(
    private val itemsInteractor: ItemsInteractor,
) : ViewModel() {

//    private val _items = MutableLiveData<List<ItemsModel>>()
//    val items: LiveData<List<ItemsModel>> = _items

    val items = flow <Flow<List<ItemsModel>>> {emit(itemsInteractor.showData())
    }

    //Способ 1(фикс дубликатов)
    val getData = flow { emit(itemsInteractor.getData()) }

    //Способ 2
    private val _trigger = MutableLiveData<Flow<Unit>>()
    val trigger = _trigger

    private val _msg = MutableLiveData<Int>()
    val msg: LiveData<Int> = _msg

    private val _bundle = MutableLiveData<NavigateWithBundle?>()
    val bundle: LiveData<NavigateWithBundle?> = _bundle


    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error


    //Способ 2
    fun getData(){
        viewModelScope.launch {
            _trigger.value = flow { emit(itemsInteractor.getData()) }
        }
    }

    //Способ 3
    suspend fun getDataSimple(){
        itemsInteractor.getData()
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

    fun onFavClicked(description: String, isFavorite: Boolean){
        viewModelScope.launch {
            itemsInteractor.onFavClicked(description,isFavorite)
        }
    }
}

data class NavigateWithBundle(
    val image: String,
    val description: String,
    val destinationId: Int
)
