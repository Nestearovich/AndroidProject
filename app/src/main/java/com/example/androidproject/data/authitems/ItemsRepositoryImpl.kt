package com.example.androidproject.data.authitems

import android.util.Log
import com.example.androidproject.data.database.ItemsEntity
import com.example.androidproject.data.database.dao.ItemsDAO
import com.example.androidproject.data.service.ApiServise
import com.example.androidproject.data.service.ApiServiseSecond
import com.example.androidproject.domain.items.ItemsRepository
import com.example.androidproject.domain.model.ItemsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*
import javax.inject.Inject
import javax.inject.Named


class ItemsRepositoryImpl @Inject constructor(
   @Named("FIRST") private val apiServise: ApiServise,
   @Named("SECOND") private val apiServiseSecond: ApiServiseSecond,
   private val itemsDAO: ItemsDAO
): ItemsRepository {

    override suspend fun getData() {
        return withContext(Dispatchers.IO) {

            if (!itemsDAO.doesItemsEntityExist()) {
                Log.w("getData","data not exist")
                val response = apiServise.getData()

                response.body()?.sampleList?.let {
                    it.map {
                        val itemsEntity =
                            ItemsEntity(Random().nextInt(), it.description, it.imageUrl)
                        itemsDAO.insertItemsEntity(itemsEntity)
                    }
                }
            }
        }
    }

    override suspend fun showData(): List<ItemsModel> {
        return withContext(Dispatchers.IO){
            val itemsEntity = itemsDAO.getItemsEntities()
            itemsEntity.map{
                ItemsModel(it.description,
                    it.imageUrl)
            }
        }
    }

    override suspend fun deleteItemByDescription(description: String) {
        withContext(Dispatchers.IO){
            itemsDAO.deleteItemEntityByDescription(description)
        }
    }

    override suspend fun findItemByDescription(searchText: String) {
        TODO("Not yet implemented")
    }

//    override suspend fun findItemByDescription(searchText: String) {
//        return withContext(Dispatchers.IO){
//           val itemsDAO.findItemEntityByDescription
//        }
//    }
}