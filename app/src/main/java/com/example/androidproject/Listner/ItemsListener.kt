package com.example.androidproject.Listner

import android.widget.ImageView

interface ItemsListener {
    fun onClick()

    fun onElementSelected(name: String, date: String, imageView:Int)
}