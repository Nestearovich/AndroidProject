package com.example.androidproject.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject.presentation.Listner.ItemsListener
import com.example.androidproject.R
import com.example.androidproject.domain.model.ItemsModel

class ItemsAdapter(
    private val itemsListener: ItemsListener
): RecyclerView.Adapter<ItemsViewHolder>() {

    private var listItems = mutableListOf<ItemsModel>()


    fun submitList(list:List<ItemsModel>){
        this.listItems = list.toMutableList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_fruit,parent,false)
        return ItemsViewHolder(view,itemsListener)
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        holder.bind(listItems[position])
    }

    override fun getItemCount(): Int {
        return listItems.size
    }
}