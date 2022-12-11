package com.example.androidproject.presentation.adapter.Listner

import android.widget.ImageView

interface ItemsListener {
    fun onClick()

    fun onElementSelected(name: String, date: String, imageView:Int)
}