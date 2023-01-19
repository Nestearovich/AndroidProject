package com.example.androidproject.data.authitems

import com.example.androidproject.R
import com.example.androidproject.data.ApiServise
import com.example.androidproject.domain.items.ItemsRepository
import com.example.androidproject.domain.model.ItemsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class ItemsRepositoryImpl @Inject constructor(
    private val apiServise: ApiServise
): ItemsRepository {



    override suspend fun getData():List<ItemsModel>{
        return  withContext(Dispatchers.IO) {
            val response = apiServise.getData()
            return response.body()?sampleList!!.let{
            it.map {
                ItemsModel(it.description, it.imageUrl)
            }
        } ?: kotlin.run {
            emptyList()
        }
        }
    }
}