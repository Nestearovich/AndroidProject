package com.example.androidproject

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidproject.model.ItemsModel

class ItemsViewModel : ViewModel() {

    private val _items = MutableLiveData<List<ItemsModel>>()
    val items : LiveData<List<ItemsModel>> = _items

    private val _msg = MutableLiveData<String>()
    val msg: LiveData<String> = _msg

    private val _bundle = MutableLiveData<NavigateWithBundle>()
    val bundle : LiveData<NavigateWithBundle> = _bundle

    fun getData(){
        val listItems = listOf<ItemsModel>(
            ItemsModel(
                R.drawable.frut,
                "ananas",
                "13.12.1202"
            ),
            ItemsModel(
                R.drawable.spd,
                "ananas",
                "13.12.1202"
            ),
            ItemsModel(
                R.drawable.icon,
                "vergel",
                "13.12.1202"
            ),
            ItemsModel(
                R.drawable.spd,
                "dante",
                "13.12.1202"
            ),
            ItemsModel(
                R.drawable.icon,
                "sleep",
                "13.12.1202"
            ),
            ItemsModel(
                R.drawable.spd,
                "cry",
                "13.12.1202"
            ),
            ItemsModel(
                R.drawable.spd,
                "rip",
                "13.12.1202"
            ),
            ItemsModel(
                R.drawable.spd,
                "spirit",
                "13.12.1202"
            ),
            ItemsModel(
                R.drawable.spd,
                "death",
                "13.12.1202"
            ),
        )

        _items.value = listItems
    }

    fun imageViewClicked(){
        _msg.value =  "ImageView clicked"
    }

    fun elementClicked(name: String, date: String, imageView: Int){
        _bundle.value = NavigateWithBundle(image = imageView,name=name,date=date)


    }

}

data class NavigateWithBundle(
    val image: Int,
    val name: String,
    val date: String
)