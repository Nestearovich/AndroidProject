package com.example.androidproject.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "ItemsEntity")
data class ItemsEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "imageUrl3")
    val imageUrl:String,
    @ColumnInfo("isFavorite")
    val isFavorite: Boolean? = false,
)
