package com.example.androidproject.di

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.example.androidproject.data.service.ApiServise
import com.example.androidproject.data.service.ApiServiseSecond
import com.example.androidproject.data.authitems.AuthRepositoryImpl
import com.example.androidproject.data.authitems.ItemsRepositoryImpl
import com.example.androidproject.data.sharedprefences.SharedPreferencesHelper
import com.example.androidproject.domain.auth.AuthRepository
import com.example.androidproject.domain.items.ItemsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named


@Module
@InstallIn(SingletonComponent::class)

abstract class DataModule {
    @Binds
   abstract fun bindItemsRepository(
        itemsRepositoryImpl: ItemsRepositoryImpl
    ): ItemsRepository

    @Binds
    abstract fun bindAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository

    companion object{
        private const val SP_KEY = "SP_KEY"
        private const val BASE_URL =  " https://api.jsonserve.com"
        private const val BASE_URL_SECOND = "https://jsonplaceholder.typicode.com"

        @Provides
        fun provideSharedPrefences(
            @ApplicationContext context: Context
        ): SharedPreferencesHelper{
            return SharedPreferencesHelper(
                context.getSharedPreferences(SP_KEY,MODE_PRIVATE)
            )
        }
        @Named ("FIRST")
        @Provides
        fun provideApiService( @Named ("FIRST")retrofit: Retrofit): ApiServise {
            return retrofit.create(ApiServise::class.java)
        }
        @Named ("FIRST")
        @Provides
        fun provideRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        @Named ("SECOND")
        @Provides
        fun provideApiServiceSecond(@Named ("SECOND")retrofit: Retrofit): ApiServiseSecond {
            return retrofit.create(ApiServiseSecond::class.java)
        }

        @Named ("SECOND")
        @Provides
        fun provideRetrofitInstanceSecond(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL_SECOND)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}