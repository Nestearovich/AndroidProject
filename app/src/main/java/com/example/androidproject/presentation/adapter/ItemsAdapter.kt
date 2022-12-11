package com.example.androidproject.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject.presentation.adapter.Listner.ItemsListener
import com.example.androidproject.R
import com.example.androidproject.databinding.ItemFruitBinding
import com.example.androidproject.model.ItemsModel

class ItemsAdapter(
    private val itemsListener: ItemsListener
): RecyclerView.Adapter<ItemsViewHolder>() {

    private var listItems = mutableListOf<ItemsModel>()//не изменно


    fun submitList(list:List<ItemsModel>){//может меняться,инициализация
        this.listItems = list.toMutableList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        val viewBinding = ItemFruitBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ItemsViewHolder(viewBinding,itemsListener)
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        holder.bind(listItems[position])
    }//вью холдер берет элементы по одному,

    override fun getItemCount(): Int {
        return listItems.size
    }
}