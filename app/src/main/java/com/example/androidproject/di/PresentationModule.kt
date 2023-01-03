package com.example.androidproject.di

import com.example.androidproject.domain.auth.AuthInteractor
import com.example.androidproject.domain.items.ItemsInteractor
import com.example.androidproject.presentation.auths.LoginPresenter
import com.example.androidproject.presentation.auths.OnBoardingPresenter
import com.example.androidproject.presentation.home.DetailPresenter
import com.example.androidproject.presentation.home.ItemsPresenter
import com.example.androidproject.presentation.view.MainPresenter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class PresentationModule {
    @Provides
    fun provideMainPresenter(authInteractor: AuthInteractor): MainPresenter{
        return MainPresenter(authInteractor)
    }
    @Provides
    fun provideLoginPresenter(authInteractor: AuthInteractor): LoginPresenter {
        return LoginPresenter(authInteractor)
    }
    @Provides
    fun provideOnBoardingPresenter(authInteractor: AuthInteractor): OnBoardingPresenter {
        return OnBoardingPresenter()
    }
    @Provides
    fun provideItemsPresenter(itemsInteractor: ItemsInteractor): ItemsPresenter {
        return ItemsPresenter(itemsInteractor)
    }
    @Provides
    fun provideDetailPresenter(authInteractor: AuthInteractor): DetailPresenter {
        return DetailPresenter(authInteractor)
    }
}