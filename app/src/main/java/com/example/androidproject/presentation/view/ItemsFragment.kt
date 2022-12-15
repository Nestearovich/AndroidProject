package com.example.androidproject.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject.utils.BundleConstant.IMAGE
import com.example.androidproject.ItemsViewModel
import com.example.androidproject.R
import com.example.androidproject.data.ItemsRepositoryImpl
import com.example.androidproject.domain.ItemsInteractor
import com.example.androidproject.presentation.Listner.ItemsListener
import com.example.androidproject.presentation.adapter.ItemsAdapter
import com.example.androidproject.utils.BundleConstant.DATE
import com.example.androidproject.utils.BundleConstant.NAME


class ItemsFragment : Fragment(), ItemsListener {

    private lateinit var itemsAdapter: ItemsAdapter

    private val viewModel : ItemsViewModel by viewModels{
        ItemsViewFactory(ItemsInteractor(ItemsRepositoryImpl()))
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

        viewModel.bundle.observe(viewLifecycleOwner){navBundle ->
            if (navBundle != null){
                val detailFragment = DetailFragment()
                val bundle = Bundle()
                bundle.putString(NAME,navBundle.name)
                bundle.putString(DATE,navBundle.date)
                bundle.putInt(IMAGE,navBundle.image)
                detailFragment.arguments = bundle

                Toast.makeText(context,"called",Toast.LENGTH_SHORT).show()

                Navigation.fmReplace(parentFragmentManager, detailFragment, true)
                viewModel.userNavigated()

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


}