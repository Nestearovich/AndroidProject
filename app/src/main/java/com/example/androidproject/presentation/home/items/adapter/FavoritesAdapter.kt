package com.example.androidproject.presentation.home.items.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject.R
import com.example.androidproject.databinding.ItemFavoriteBinding
import com.example.androidproject.domain.model.FavoritesModel
import com.example.androidproject.domain.model.ItemsModel
import com.example.androidproject.presentation.Listner.ItemsListener
import com.example.androidproject.presentation.adapter.ItemsViewHolder

class FavoritesAdapter (

): RecyclerView.Adapter<FavoritesViewHolder>() {

    private var listItems = mutableListOf<FavoritesModel>()

    fun submitList(list:List<FavoritesModel>){
        this.listItems.clear()
        this.listItems = list.toMutableList()
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesViewHolder {
        val viewBinding = ItemFavoriteBinding.inflate(
            LayoutInflater.from(parent.context),parent,false

        )
        return FavoritesViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: FavoritesViewHolder, position: Int) {
        holder.bind(listItems[position])
    }

    override fun getItemCount(): Int {
        return listItems.size
    }
}