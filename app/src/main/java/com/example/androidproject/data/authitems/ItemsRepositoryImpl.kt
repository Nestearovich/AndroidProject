package com.example.androidproject.data.authitems

import android.util.Log
import com.example.androidproject.data.database.FavoritesEntity
import com.example.androidproject.data.database.ItemsEntity
import com.example.androidproject.data.database.dao.ItemsDAO
import com.example.androidproject.data.service.ApiServise
import com.example.androidproject.data.service.ApiServiseSecond
import com.example.androidproject.domain.items.ItemsRepository
import com.example.androidproject.domain.model.FavoritesModel
import com.example.androidproject.domain.model.ItemsModel
import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
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


    private val compositeDisposable = CompositeDisposable()
    override fun getData(): Completable {
        return itemsDAO.doesItemsEntityExist()
            .subscribeOn(Schedulers.io())
            .doAfterNext {
                if (!it) {
                    val response = apiServise.getData()
                    val getData = response.subscribeOn(Schedulers.io())
                        .doAfterSuccess {

                            it.sampleList.map {
                                val itemsEntity =
                                    ItemsEntity(Random().nextInt(), it.description, it.imageUrl)
                                itemsDAO.insertItemsEntity(itemsEntity)
                            }
                        }
                        .doOnError {
                            Log.w("error", "when making request")
                        }
                        .ignoreElement()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe()
                        compositeDisposable.add(getData)
                }
            }.ignoreElements()
            .observeOn(AndroidSchedulers.mainThread())

    }


    override fun showData(): io.reactivex.Observable<List<ItemsModel>> {
        val itemsEntity = itemsDAO.getItemsEntities()
        return itemsEntity.subscribeOn(Schedulers.io())
            .map {
                it.map {
                    ItemsModel(it.id, it.description, it.imageUrl, it.isFavorite ?: false)
                }
            }
            .observeOn(AndroidSchedulers.mainThread())
    }

//        return   itemsEntity.map{
//                ItemsModel(it.id, it.description,it.imageUrl)
//            }

    override suspend fun deleteItemByDescription(description: String) {
        withContext(Dispatchers.IO){
            itemsDAO.deleteItemEntityByDescription(description)
        }
    }


    override suspend fun findItemByDescription(searchText: String):ItemsModel {
        return withContext(Dispatchers.IO){
          val itemsEntity = itemsDAO.findItemEntityByDescription(searchText)
            ItemsModel(itemsEntity.id, itemsEntity.description,itemsEntity.imageUrl,itemsEntity.isFavorite ?:false)
       }
   }

    override suspend fun favClicked(itemsModel: ItemsModel, isFavorite: Boolean) {
        return withContext(Dispatchers.IO){

            itemsDAO.addToFavorite(
                itemsModel.description,
                isFavorite
            )

            itemsDAO.insertFavoritesEntity(
                FavoritesEntity(
                    itemsModel.id,
                    itemsModel.description,
                    itemsModel.image)
            )
        }
    }

    override suspend fun getFavorites(): List<FavoritesModel> {
        return withContext(Dispatchers.IO){
            val favoritesEntity = itemsDAO.getFavoriteEntities()
            favoritesEntity.map {
                FavoritesModel(
                    it.description,
                    it.imageUrl)
            }
        }
    }

}