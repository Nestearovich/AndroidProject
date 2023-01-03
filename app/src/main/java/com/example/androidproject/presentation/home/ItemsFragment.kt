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
import com.example.androidproject.databinding.FragmentItemsBinding
import com.example.androidproject.databinding.FragmentLoginBinding
import com.example.androidproject.domain.model.ItemsModel
import com.example.androidproject.presentation.Listner.ItemsListener
import com.example.androidproject.presentation.adapter.ItemsAdapter
import com.example.androidproject.utils.BundleConstant.DATE
import com.example.androidproject.utils.BundleConstant.NAME
import com.example.androidproject.utils.Navigation
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ItemsFragment : Fragment(), ItemsListener, ItemsView {

    private lateinit var itemsAdapter: ItemsAdapter

    private var _binding: FragmentItemsBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var itemsPresenter: ItemsPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentItemsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        itemsPresenter.setView(this)

        itemsAdapter = ItemsAdapter(this)

        // val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        //recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = itemsAdapter

        itemsPresenter.getItems()


    }

    override fun onClick() {
        itemsPresenter.imageViewClicked()
    }

    override fun onElementSelected(name: String, date: String, imageView: Int) {
        itemsPresenter.itemClicked(name, date, imageView)
    }

    override fun itemsReceived(itemsList: List<ItemsModel>) {
        itemsAdapter.submitList(itemsList)
    }

    override fun imageViewClicked(msg: Int) {
        Toast.makeText(context, getString(msg), Toast.LENGTH_SHORT).show()
    }

    override fun itemClicked(navigationData: NavigateWithBundle) {
        val detailFragment = DetailFragment()
        val bundle = Bundle()
        bundle.putString(NAME, navigationData.name)
        bundle.putString(DATE, navigationData.date)
        bundle.putInt(IMAGE, navigationData.image)
        detailFragment.arguments = bundle

        Toast.makeText(context, "called", Toast.LENGTH_SHORT).show()

        Navigation.fmReplace(parentFragmentManager, detailFragment, true)
    }
}
