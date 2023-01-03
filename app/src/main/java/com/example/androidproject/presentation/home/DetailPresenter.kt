package com.example.androidproject.presentation.home

import com.example.androidproject.domain.auth.AuthInteractor
import javax.inject.Inject

class DetailPresenter @Inject constructor(
    private val authInteractor: AuthInteractor
) {

    private lateinit var detailView: DetailView
    fun setView(detailFragment: DetailFragment){
        detailView = detailFragment
    }

    fun getArguments(name: String, date: String, imageView: Int){
        detailView.disolayItemData(
            when(name.isNullOrEmpty()){
                true ->"HAHA NO DATA"
                false -> name
            },
            when(date.isNullOrEmpty()){
                true -> "NO DATA"
                false -> date
            },
            imageView)
    }

    fun logoutUser(){
        authInteractor.logoutUser()
        detailView.userLoggedOut()
    }
}