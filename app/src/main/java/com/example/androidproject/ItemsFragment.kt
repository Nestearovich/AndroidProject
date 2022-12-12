package com.example.androidproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject.BundleConstant.IMAGE
import com.example.androidproject.Listner.ItemsListener
import com.example.androidproject.adapter.ItemsAdapter
import com.example.androidproject.model.ItemsModel
import java.util.jar.Attributes
//НЕ ИСПОЛЬЗОВАТЬ
 //private const val NAME = "name"

class ItemsFragment : Fragment(),ItemsListener {

    private lateinit var itemsAdapter: ItemsAdapter

    private val viewModel : ItemsViewModel by viewModels{
        ItemsViewFactory(TestParametr())
    }

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
            Toast.makeText(context,getString(msg),Toast.LENGTH_SHORT).show()
        }
//одноразовое действие
        viewModel.bundle.observe(viewLifecycleOwner){navBundle ->
            if (navBundle != null){
                val detailFragment = DetailFragment()
                val bundle = Bundle()
                bundle.putString(NAME,navBundle.name)
                bundle.putString(DATE,navBundle.date)
                bundle.putInt(IMAGE,navBundle.image)
                detailFragment.arguments =bundle

                Toast.makeText(context,"called",Toast.LENGTH_SHORT).show()

                parentFragmentManager
                    .beginTransaction()
                    .add(R.id.activity_container,DetailFragment())
                    .addToBackStack("Details")
                    .commit()

                viewModel.userNavigated()
            }

        }
    }


    override fun onClick() {
        viewModel.imageViewClicked()
    }

    override fun onElementSelected(name: String, date: String, imageView: Int) {
        viewModel.elementClicked(name, date, imageView)
    }
    //WE CAN USE IT,BECAUSE
    companion object{
        const val DATE = "date"
        const val NAME = "name"
    }

}