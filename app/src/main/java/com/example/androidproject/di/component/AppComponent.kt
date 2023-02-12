package com.example.androidproject.di.component

import com.example.androidproject.di.*
import com.example.androidproject.di.factory.ScreenScope
import com.example.androidproject.presentation.auths.LoginFragment
import com.example.androidproject.presentation.home.HomeFragment
import com.example.androidproject.presentation.home.items.DetailFragment
import com.example.androidproject.presentation.home.items.FavoritesFragment
import com.example.androidproject.presentation.home.items.ItemsFragment
import com.example.androidproject.presentation.home.items.SearchFragment
import com.example.androidproject.presentation.view.MainActivity
import dagger.Component


@Component(
    modules = [
        AppModule::class,
        DataBaseModule::class,
        DataModule::class,
        DomainModule::class,
        ViewModelModule::class
    ]
)
@ScreenScope
interface AppComponent {
    fun inject(loginFragment: LoginFragment)
    fun inject(detailsFragment: DetailFragment)
    fun inject(itemsFragment: ItemsFragment)
    fun inject(favoritesFragment: FavoritesFragment)
    fun inject(searchFragment: SearchFragment)
    fun inject(homeFragment: HomeFragment)
    fun inject(mainActivity: MainActivity)
}