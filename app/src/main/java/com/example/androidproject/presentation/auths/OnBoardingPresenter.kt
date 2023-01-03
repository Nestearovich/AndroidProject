package com.example.androidproject.presentation.auths

import javax.inject.Inject

class OnBoardingPresenter @Inject constructor() {

    private lateinit var onBoardinView: OnBoardinView
    fun setView(onBoardingFragment: OnBoardingFragment){
        onBoardinView = onBoardingFragment
    }

    fun goToItemsFragment(){
        onBoardinView.goToItemsFragment()
    }

}