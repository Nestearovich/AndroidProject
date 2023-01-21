package com.example.androidproject.data.service

import com.example.androidproject.di.model.ItemsResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiServise  {

    @GET("/nkuYRM")
    suspend fun getData(): Response<ItemsResponse>
}