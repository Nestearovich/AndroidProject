package com.example.androidproject.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidproject.di.factory.ViewModelFactory
import com.example.androidproject.di.factory.ViewModelKey
import com.example.androidproject.presentation.auths.LoginViewModel
import com.example.androidproject.presentation.home.HomeViewModel
import com.example.androidproject.presentation.home.ItemsViewModel
import com.example.androidproject.presentation.home.items.DetailsViewModel
import com.example.androidproject.presentation.home.items.FavoritesViewModel
import com.example.androidproject.presentation.home.items.SearchViewModel
import com.example.androidproject.presentation.view.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class ViewModelModule() {

    @Binds
    abstract fun bindViewFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginViewModel(viewModel: LoginViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ItemsViewModel::class)
    abstract fun bindItemsViewModel(viewModel: ItemsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailsViewModel::class)
    abstract fun bindDetailsViewModel(viewModel: DetailsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FavoritesViewModel::class)
    abstract fun bindFavoriteViewModel(viewModel: FavoritesViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    abstract fun bindSearchViewModel(viewModel: SearchViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

}