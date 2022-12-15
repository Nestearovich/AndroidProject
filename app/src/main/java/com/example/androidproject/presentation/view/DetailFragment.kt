package com.example.androidproject.presentation.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.androidproject.utils.BundleConstant.IMAGE
import com.example.androidproject.R
import com.example.androidproject.utils.BundleConstant.DATE
import com.example.androidproject.utils.BundleConstant.NAME


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
            val name = bundle.getString(NAME)
            val date = bundle.getString(DATE)
            val image = bundle.getInt(IMAGE)


            detailsName.text = name
            detailsDate.text = date
            detailsImage.setBackgroundResource(image)
        }

    }
}
