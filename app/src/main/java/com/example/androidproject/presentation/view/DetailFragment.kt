package com.example.androidproject.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.androidproject.R
import com.example.androidproject.databinding.FragmentDetailBinding



class DetailFragment : Fragment() {

    private var _viewBinding: FragmentDetailBinding? = null
    private val viewBinding get() = _viewBinding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _viewBinding = FragmentDetailBinding.inflate(inflater)
        return viewBinding.root
       // return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        val bundle = arguments
        bundle?.let{ safeBundle ->
            val name = bundle.getString("name")
            val date = bundle.getString("date")
            val image = bundle.getInt("imageView")


            viewBinding.textView4.text = name
            viewBinding.textView3.text = date
            viewBinding.imageView.setBackgroundResource(image)
        }

    }
}
