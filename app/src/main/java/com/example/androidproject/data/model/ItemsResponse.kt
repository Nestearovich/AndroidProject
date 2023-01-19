package com.example.androidproject.data.model

import com.google.gson.annotations.SerializedName
import java.io.FileDescriptor

data class ItemsResponse(
    @SerializedName("sample")
    val sampleList: List<Sample>
)

data class Sample(
    @SerializedName("description")
    val descriptor:String,
    @SerializedName("image-url")
val imageUrl: String
)