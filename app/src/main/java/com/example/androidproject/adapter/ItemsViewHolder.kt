package com.example.androidproject.adapter

import android.view.TextureView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject.Listner.ItemsListener
import com.example.androidproject.R
import com.example.androidproject.model.ItemsModel

class ItemsViewHolder(
    private val view: View,
    private val itemsListener: ItemsListener
):RecyclerView.ViewHolder(view) {

   fun bind(itemsModel: ItemsModel){

        val name = view.findViewById<TextView>(R.id.textView)
        val imageView = view.findViewById<ImageView>(R.id.frut)
       val date = view.findViewById<TextView>(R.id.textV)
       //val date = view.findViewById<TextView>(R.id.textV)

       name.text = itemsModel.name
       imageView.setBackgroundResource(itemsModel.image)
       date.text = itemsModel.date   //проинициализировали

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