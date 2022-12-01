package com.example.androidproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject.Listner.ItemsListener
import com.example.androidproject.adapter.ItemsAdapter
import com.example.androidproject.model.ItemsModel

class ItemsFragment : Fragment(),ItemsListener {

    private lateinit var itemsAdapter: ItemsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_items, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        itemsAdapter = ItemsAdapter(this)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        recyclerView.adapter = itemsAdapter

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
        )

        itemsAdapter.submitList(listItems.toList())
    }

    override fun onClick() {
        Toast.makeText(context,"ImageView clicked",Toast.LENGTH_SHORT).show()
    }

    override fun onElementSelected(name: String, date: String, imageView: Int) {
        val detailFragment = DetailFragment()//экземпляр фрагмента
        val bundle = Bundle()//bundle - это место где можно хранить
        bundle.putString("name",name)//ключи должны быть константами
        bundle.putString("date",date)
        bundle.putInt("imageView",imageView)
        detailFragment.arguments =bundle

//TODO add метод мы больше не используем
            //теперь всегда будем использовать replace
        //replace всегда будет иметь идли addToBackstack чтобы
        //могли вернуться назад или же его не будет,чтобы
        //мы вернулись назад
        parentFragmentManager
            .beginTransaction()
            .add(R.id.activity_container,DetailFragment())
            .addToBackStack("Details")
            .commit()
    }

}