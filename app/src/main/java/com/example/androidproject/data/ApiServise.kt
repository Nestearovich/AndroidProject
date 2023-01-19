package com.example.androidproject.data

import com.example.androidproject.data.model.ItemsResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiServise  {

    @GET("/nkuYRM")
    suspend fun getData(): Response<ItemsResponse>
}