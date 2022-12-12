package com.example.androidproject.presentation.adapter

import android.view.TextureView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject.presentation.adapter.Listner.ItemsListener
import com.example.androidproject.R
import com.example.androidproject.databinding.ItemFruitBinding
import com.example.androidproject.model.ItemsModel

class ItemsViewHolder(
    private val viewBinding: ItemFruitBinding,
    private val itemsListener: ItemsListener
):RecyclerView.ViewHolder(viewBinding.root) {

   fun bind(itemsModel: ItemsModel){

       // val name = view.findViewById<TextView>(R.id.textView)
       // val imageView = view.findViewById<ImageView>(R.id.frut)
      // val date = view.findViewById<TextView>(R.id.textV)
       //val date = view.findViewById<TextView>(R.id.textV)

       viewBinding.textView.text = itemsModel.name
       viewBinding.frut.setBackgroundResource(itemsModel.image)
       viewBinding.textV.text = itemsModel.date   //проинициализировали

       viewBinding.frut.setOnClickListener{
           itemsListener.onClick()
       }

       itemView.setOnClickListener {
           itemsListener.onElementSelected(itemsModel.name,
           itemsModel.date,
           itemsModel.image)
       }
    }
}