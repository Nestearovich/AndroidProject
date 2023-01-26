package com.example.androidproject.data.database.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.androidproject.data.database.ItemsEntity

@Database(entities = [ItemsEntity::class], version = 1, exportSchema = false)
abstract class ItemsDataBase: RoomDatabase () {

    abstract fun getItemsDao(): ItemsDAO


    companion object{
        private const val DATABASE_NAME = "tms_db"
        private var DATABASE_INSTANCE: ItemsDataBase? = null

        fun getItemsDatabaseInstance(context: Context):ItemsDataBase{
            return DATABASE_INSTANCE?:Room
                .databaseBuilder(
                    context.applicationContext,
                    ItemsDataBase::class.java,
                    DATABASE_NAME
                ).build()
                .also { DATABASE_INSTANCE = it }
        }
    }
}
//этот класс в основном всегда остается таким