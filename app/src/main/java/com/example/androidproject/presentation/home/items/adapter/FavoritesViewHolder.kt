package com.example.androidproject.presentation.home.items.adapter

import android.net.Uri
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.androidproject.R
import com.example.androidproject.databinding.ItemFavoriteBinding
import com.example.androidproject.domain.model.FavoritesModel
import com.example.androidproject.domain.model.ItemsModel
import com.example.androidproject.presentation.Listner.ItemsListener


class FavoritesViewHolder(
    private val viewBinding: ItemFavoriteBinding,

): RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(favItems:FavoritesModel){
        viewBinding.tvName.text = favItems.descripstion
        //Picasso.get().load(Uri.parse(favItems.image)).into(viewBinding.image)

    }
}