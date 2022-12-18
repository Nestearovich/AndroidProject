package com.example.androidproject.data

import com.example.androidproject.R
import com.example.androidproject.domain.ItemsRepository
import com.example.androidproject.model.ItemsModel
import javax.inject.Inject


class ItemsRepositoryImpl @Inject constructor(): ItemsRepository {

    override fun getData():List<ItemsModel>{
        val listItems = listOf<ItemsModel>(
            ItemsModel(
                R.drawable.frut,
                "ananas",
                "13.12.1202"
            ),
            ItemsModel(
                R.drawable.spd,
                "ananas",
                "13.12.1202"
            ),
            ItemsModel(
                R.drawable.icon,
                "vergel",
                "13.12.1202"
            ),
            ItemsModel(
                R.drawable.spd,
                "dante",
                "13.12.1202"
            ),
            ItemsModel(
                R.drawable.icon,
                "sleep",
                "13.12.1202"
            ),
            ItemsModel(
                R.drawable.spd,
                "cry",
                "13.12.1202"
            ),
            ItemsModel(
                R.drawable.spd,
                "rip",
                "13.12.1202"
            ),
            ItemsModel(
                R.drawable.spd,
                "spirit",
                "13.12.1202"
            ),
            ItemsModel(
                R.drawable.spd,
                "death",
                "13.12.1202"
            ),
            ItemsModel(
                R.drawable.spd,
                "ananas",
                "13.12.1202"
            ),
            ItemsModel(
                R.drawable.spd,
                "ananas",
                "13.12.1202"
            ),
            ItemsModel(
                R.drawable.spd,
                "ananas",
                "13.12.1202"
            ),
            ItemsModel(
                R.drawable.spd,
                "ananas",
                "13.12.1202"
            ),
            ItemsModel(
                R.drawable.spd,
                "ananas",
                "13.12.1202"
            ),
        )
        return listItems
    }
}