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
    private val viewBinding: ItemFruitBinding ,
    private val itemsListener: ItemsListener
):RecyclerView.ViewHolder(viewBinding.root) {

   fun bind(itemsModel: ItemsModel){

       viewBinding.textView.text = itemsModel.descripstion

       Picasso.get().load(Uri.parse(itemsModel.image)).into(viewBinding.ivImage)

       imageView.setOnClickListener{
           itemsListener.onClick()
       }

       itemView.setOnClickListener {
           itemsListener.onElementSelected(
               itemsModel.descripstion,
           itemsModel.image)
       }
    }
}