package com.example.androidproject.presentation.home

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
import com.example.androidproject.R
import com.example.androidproject.presentation.Listner.ItemsListener
import com.example.androidproject.presentation.adapter.ItemsAdapter
import com.example.androidproject.utils.BundleConstant
import com.example.androidproject.utils.BundleConstant.DESCRIPTION
import com.example.androidproject.utils.BundleConstant.NAME
import com.example.androidproject.utils.NavHelper.navigateWithBundle
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ItemsFragment : Fragment(), ItemsListener {

    private lateinit var itemsAdapter: ItemsAdapter

    private val viewModel: ItemsViewModel by viewModels()

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

        viewModel.items.observe(viewLifecycleOwner) { listItems ->
            itemsAdapter.submitList(listItems)
        }

        viewModel.msg.observe(viewLifecycleOwner) { msg ->
            Toast.makeText(context, getString(msg), Toast.LENGTH_SHORT).show()
        }

        viewModel.bundle.observe(viewLifecycleOwner) { navBundle ->
            if (navBundle != null) {
                val bundle = Bundle()
                bundle.putString(IMAGE,navBundle.description)
                bundle.putString(DESCRIPTION,navBundle.image)

                Toast.makeText(context, "called", Toast.LENGTH_SHORT).show()

                navigateWithBundle(
                    R.id.action_itemsFragment_to_detailFragment,
                    bundle
                )
                viewModel.userNavigated()
            }
        }
        viewModel.error.observe(viewLifecycleOwner){
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        }
    }
    override fun onClick() {
        viewModel.imageViewClicked()
    }
    override fun onElementSelected(description: String, image: String) {
        viewModel.elementClicked(description,image)
    }

}