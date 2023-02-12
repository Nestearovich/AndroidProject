package com.example.androidproject.presentation.home.items

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject.App
import com.example.androidproject.R
import com.example.androidproject.presentation.Listner.ItemsListener
import com.example.androidproject.presentation.adapter.ItemsAdapter
import com.example.androidproject.presentation.home.ItemsViewModel
import com.example.androidproject.utils.BaseFragment
import com.example.androidproject.utils.BundleConstant.DESCRIPTION
import com.example.androidproject.utils.BundleConstant.IMAGE
import com.example.androidproject.utils.NavHelper.navigateWithBundle
import kotlinx.coroutines.flow.catch


class ItemsFragment : BaseFragment(), ItemsListener {

    private lateinit var itemsAdapter: ItemsAdapter

    private val viewModel: ItemsViewModel by viewModels{viewModelFactory}
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_items, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        (requireActivity().applicationContext as App).provideAppComponent().inject(this)

        itemsAdapter = ItemsAdapter(this)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = itemsAdapter

        //Способ 1(фикс дублирование элементов)
//        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
//            viewModel.getData.collect()
//        }

        //Способ 2(фикс дублирование элементов)
//        viewModel.getData()
//        viewModel.trigger.observe(viewLifecycleOwner){
//            viewLifecycleOwner.lifecycleScope.launchWhenResumed {
//                it.collect()
//            }
//        }

        //Способ 3(самый красивый и лёгкий)
        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            viewModel.getDataSimple()
        }

        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            viewModel.items.catch {
                Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
            }.collect{flowList ->
                flowList.collect{ list ->
                    itemsAdapter.submitList(list)
                }

            }
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

    override fun onDeleteClicked(description: String) {
       viewModel.deleteItem(description)
    }

    override fun onFavClicked(description: String, isFavorite: Boolean) {
        viewModel.onFavClicked(description, isFavorite)
    }
}