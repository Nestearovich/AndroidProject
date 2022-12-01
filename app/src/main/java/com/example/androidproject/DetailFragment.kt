package com.example.androidproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView


class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val detailsName = view.findViewById<TextView>(R.id.textView3)
        val detailsDate = view.findViewById<TextView>(R.id.textView4)
        val detailsImage = view.findViewById<ImageView>(R.id.imageView)


        val bundle = arguments
        bundle?.let{ safeBundle ->
            val name = bundle.getString("name")
            val date = bundle.getString("date")
            val image = bundle.getInt("imageView")


            detailsName.text = name
            detailsDate.text = date
            detailsImage.setBackgroundResource(image)
        }

    }
}
