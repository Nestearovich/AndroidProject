package com.example.androidproject.di.model

import java.net.URL

data class PhotoResponse(
    val albumId: Int,
    val id: Int,
    val title:String,
    val url: String,
    val thumbnailUrl: String
)

