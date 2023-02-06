package com.example.androidproject.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.Query
import com.example.androidproject.data.database.FavoritesEntity
import com.example.androidproject.data.database.ItemsEntity
import kotlinx.coroutines.flow.Flow



@Dao
interface ItemsDAO {

    @Insert(onConflict = IGNORE)
    fun insertItemsEntity(itemsEntity: ItemsEntity)

    @Query("SELECT * From ItemsEntity")
    fun getItemsEntities(): Flow<List<ItemsEntity>>

    @Query("SELECT (SELECT COUNT(*) FROM ItemsEntity) !=0")
    fun doesItemsEntityExist(): Boolean

    @Query("DELETE FROM ItemsEntity WHERE description =:description")
    fun deleteItemEntityByDescription(description:String)

    @Query("SELECT * FROM ItemsEntity WHERE description = :searchText")
    fun findItemEntityByDescription(searchText:String): ItemsEntity

    @Insert(onConflict = IGNORE)//IGNORE WHEN CONFLICT OCCRS
    fun insertFavoritesEntity(favoritesEntity: FavoritesEntity)

    @Query("SELECT * FROM favoritesEntity")
    fun getFavoriteEntities(): List<FavoritesEntity>
}