package com.example.androidproject.data.authitems

import android.util.Log
import com.example.androidproject.data.service.ApiServise
import com.example.androidproject.data.service.ApiServiseSecond
import com.example.androidproject.domain.items.ItemsRepository
import com.example.androidproject.domain.model.ItemsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Named


class ItemsRepositoryImpl @Inject constructor(
   @Named("FIRST") private val apiServise: ApiServise,
   @Named("SECOND") private val apiServiseSecond: ApiServiseSecond,
): ItemsRepository {



    override suspend fun getData():List<ItemsModel>{
        return  withContext(Dispatchers.IO) {

            val responseSecond = apiServiseSecond.getPhotoById(8)
            Log.w("SECOND RESRONSE",responseSecond.body()?.title.toString())

            val responseSecondQuery = apiServiseSecond.getPhotoByTitle( "culpa ipsam nobis qui fuga magni et mollitia")
            Log.w("SECOND RESRONSE QUERY",responseSecondQuery.body()?.get(0).toString())

            val response = apiServise.getData()
             response.body()?.sampleList?.let{
            it.map {
                ItemsModel(it.description, it.imageUrl)
            }
        } ?: kotlin.run {
            emptyList()
        }
        }
    }
}