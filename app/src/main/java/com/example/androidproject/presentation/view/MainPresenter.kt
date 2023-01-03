package com.example.androidproject.presentation.view

import com.example.androidproject.domain.auth.AuthInteractor
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val authInteractor: AuthInteractor
) {

    private lateinit var mainView: MainView

    fun setView(mainActivity: MainActivity){
        mainView = mainActivity
    }

    fun checkUserExists(){
     val doesUserExist = authInteractor.checkUserExists()
     mainView.userExistsResult(doesUserExist)

    }
}