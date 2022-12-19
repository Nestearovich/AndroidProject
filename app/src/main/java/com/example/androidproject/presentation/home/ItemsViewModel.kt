package com.example.androidproject.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidproject.R
import com.example.androidproject.domain.items.ItemsInteractor
import com.example.androidproject.domain.model.ItemsModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ItemsViewModel @Inject constructor(
    private val itemsInteractor: ItemsInteractor,
) : ViewModel() {

    private val _items = MutableLiveData<List<ItemsModel>>()
    val items : LiveData<List<ItemsModel>> = _items

    private val _msg = MutableLiveData<Int>()
    val msg: LiveData<Int> = _msg

    private val _bundle = MutableLiveData<NavigateWithBundle?>()
    val bundle : LiveData<NavigateWithBundle?> = _bundle


    fun getData() {
        val listItems = itemsInteractor.getData()
        _items.value = listItems
    }


    fun imageViewClicked(){
        _msg.value = R.string.imageView_clicked
    }

    fun elementClicked(name: String, date: String, imageView: Int){
        _bundle.value = NavigateWithBundle(
            image = imageView,
            name=name,
            date=date)


    }

    fun userNavigated(){
        _bundle.value = null
    }

}



data class NavigateWithBundle(
    val image: Int,
    val name: String,
    val date: String
)
