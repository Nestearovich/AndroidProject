package com.example.androidproject.presentation.Listner

import java.io.FileDescriptor

interface ItemsListener {
    fun onClick()

    fun onElementSelected(descriptor: String, image: String)
}