package com.example.androidproject.data.database.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.androidproject.data.database.FavoritesEntity
import com.example.androidproject.data.database.ItemsEntity

@Database(entities = [ItemsEntity::class, FavoritesEntity::class], version = 3, exportSchema = false)
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
                )
                .addMigrations(MIGRATION_2_TO_3)
                .build()
                .also { DATABASE_INSTANCE = it }
        }
        val  MIGRATION_2_TO_3 = object :Migration(2,3){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE ItemsEntity RENAME COLUMN imageUrl TO imageUrl3")
            }
        }
    }
}
//этот класс в основном всегда остается таким