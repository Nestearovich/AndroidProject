package com.example.androidproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject.Listner.ItemsListener
import com.example.androidproject.adapter.ItemsAdapter
import com.example.androidproject.model.ItemsModel

class ItemsFragment : Fragment(),ItemsListener {

    private lateinit var itemsAdapter: ItemsAdapter

    private val viewModel : ItemsViewModel by viewModels()

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


       viewModel.getData()

        viewModel.items.observe(viewLifecycleOwner){listItems ->
            itemsAdapter.submitList(listItems)
        }

        viewModel.msg.observe(viewLifecycleOwner){msg ->
            Toast.makeText(context,msg,Toast.LENGTH_SHORT).show()
        }

        viewModel.bundle.observe(viewLifecycleOwner){navBundle ->
            val detailFragment = DetailFragment()
            val bundle = Bundle()
            bundle.putString("name",navBundle.name)
            bundle.putString("date",navBundle.date)
            bundle.putInt("imageView",navBundle.image)
            detailFragment.arguments =bundle

            parentFragmentManager
                .beginTransaction()
                .add(R.id.activity_container,DetailFragment())
                .addToBackStack("Details")
                .commit()
        }
    }


    override fun onClick() {
        viewModel.imageViewClicked()
    }

    override fun onElementSelected(name: String, date: String, imageView: Int) {
        viewModel.elementClicked(name, date, imageView)
    }

}