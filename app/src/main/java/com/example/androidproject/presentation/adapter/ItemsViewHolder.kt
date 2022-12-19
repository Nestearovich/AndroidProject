package com.example.androidproject.presentation.adapter

import android.view.TextureView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject.presentation.Listner.ItemsListener
import com.example.androidproject.R
import com.example.androidproject.domain.model.ItemsModel

class ItemsViewHolder(
    private val view: View,
    private val itemsListener: ItemsListener
):RecyclerView.ViewHolder(view) {

   fun bind(itemsModel: ItemsModel){

        val name = view.findViewById<TextView>(R.id.textView)
        val imageView = view.findViewById<ImageView>(R.id.frut)
       val date = view.findViewById<TextView>(R.id.textV)


       name.text = itemsModel.name
       imageView.setBackgroundResource(itemsModel.image)
       date.text = itemsModel.date

       imageView.setOnClickListener{
           itemsListener.onClick()
       }

       itemView.setOnClickListener {
           itemsListener.onElementSelected(itemsModel.name,
           itemsModel.date,
           itemsModel.image)
       }
    }
}