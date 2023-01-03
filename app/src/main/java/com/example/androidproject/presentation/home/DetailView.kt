package com.example.androidproject.presentation.home

interface DetailView {
    fun userLoggedOut()

    fun disolayItemData(name: String, date: String, imageView: Int)

}