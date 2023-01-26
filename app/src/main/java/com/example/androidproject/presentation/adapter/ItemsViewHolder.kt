package com.example.androidproject.presentation.adapter

import android.net.Uri
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject.presentation.Listner.ItemsListener
import com.example.androidproject.R
import com.example.androidproject.databinding.FragmentLoginBinding
import com.example.androidproject.databinding.ItemFruitBinding
import com.example.androidproject.domain.model.ItemsModel
import com.squareup.picasso.Picasso

class ItemsViewHolder(
    private val view:View,
    private val itemsListener: ItemsListener
):RecyclerView.ViewHolder(view) {

   fun bind(itemsModel: ItemsModel){
       val name = view.findViewById<TextView>(R.id.tv_name)
       val imageView = view.findViewById<ImageView>(R.id.image)
val deleteView = view.findViewById<ImageView>(R.id.idelete)
       name.text = itemsModel.descripstion

       Picasso.get().load(Uri.parse(itemsModel.image)).into(imageView)

       imageView.setOnClickListener{
           itemsListener.onClick()
       }

       itemView.setOnClickListener {
           itemsListener.onElementSelected(
               itemsModel.descripstion,
           itemsModel.image)
       }
       deleteView.setOnClickListener {
           itemsListener.onDeleteClicked(itemsModel.descripstion)
       }
    }
}