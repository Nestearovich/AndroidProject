package com.example.androidproject.presentation.Listner

import java.io.FileDescriptor

interface ItemsListener {
    fun onClick()

    fun onElementSelected(description: String, image: String)

    fun onDeleteClicked(description:String)

    fun onFavClicked(description: String,isFavorite: Boolean)
}