package com.example.androidproject.di.model

import com.google.gson.annotations.SerializedName
import java.io.FileDescriptor

data class ItemsResponse(
    @SerializedName("sample")
    val sampleList: List<Sample>
)

data class Sample(
    @SerializedName("description")
    val description:String,

    @SerializedName("image-url")
val imageUrl: String
)