package com.example.androidproject.data.service

import com.example.androidproject.di.model.PhotoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiServiseSecond {

    @GET("/photos/{id} ")
    suspend fun getPhotoById(@Path("id") photoInt: Int): Response<PhotoResponse>

    @GET("/photos")
    suspend fun  getPhotoByTitle(@Query("title") title: String): Response<List<PhotoResponse>>
}