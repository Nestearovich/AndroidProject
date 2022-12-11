package com.example.androidproject.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject.presentation.adapter.Listner.ItemsListener
import com.example.androidproject.R
import com.example.androidproject.data.ItemsRepositoryImpl
import com.example.androidproject.databinding.FragmentItemsBinding
import com.example.androidproject.databinding.FragmentOnBoardingBinding
import com.example.androidproject.domain.ItemsInteractor
import com.example.androidproject.presentation.adapter.ItemsAdapter
import com.example.androidproject.model.ItemsModel

class ItemsFragment : Fragment(), ItemsListener, ItemsView {

    private var _viewBinding: FragmentItemsBinding? = null
    private val viewBinding get() = _viewBinding!!


    private lateinit var itemsAdapter: ItemsAdapter

    lateinit var itemsPresenter: ItemsPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _viewBinding = FragmentItemsBinding.inflate(inflater)
        return viewBinding.root
       // return inflater.inflate(R.layout.fragment_items, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemsPresenter = ItemsPresenter(this, ItemsInteractor(ItemsRepositoryImpl()))


        itemsAdapter = ItemsAdapter(this)


        itemsPresenter.getDate()

        viewBinding.recyclerView.adapter = itemsAdapter



    }

    override fun onClick() {
        itemsPresenter.imageViewClicked()
        Toast.makeText(context,getString(R.string.imageview_clicked),Toast.LENGTH_SHORT).show()
    }

    override fun onElementSelected(name: String, date: String, imageView: Int) {
        itemsPresenter.elementSelected(name,date,imageView)



    }

    override fun dataReceived(list: List<ItemsModel>) {
        itemsAdapter.submitList(list)
    }

    override fun imageViewClicked(msg: Int) {
        Toast.makeText(context,getString(msg),Toast.LENGTH_SHORT).show()
    }

    override fun goToDetails(name: String, date: String, imageView: Int) {
        val detailFragment = DetailFragment()
        val bundle = Bundle()
        bundle.putString("name",name)
        bundle.putString("date",date)
        bundle.putInt("imageView",imageView)
        detailFragment.arguments =bundle

        parentFragmentManager
            .beginTransaction()
            .add(R.id.activity_container, DetailFragment())
            .addToBackStack("Details")
            .commit()
    }


}