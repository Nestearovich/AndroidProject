package com.example.androidproject.presentation.home.items

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidproject.App
import com.example.androidproject.databinding.FragmentFavoritsBinding
import com.example.androidproject.presentation.home.items.adapter.FavoritesAdapter
import com.example.androidproject.utils.BaseFragment


class FavoritesFragment : BaseFragment() {

    private var _viewBinding: FragmentFavoritsBinding? = null
    private val viewBinding get() = _viewBinding!!

    private lateinit var favAdapter: FavoritesAdapter

    private val viewModel: FavoritesViewModel by viewModels{viewModelFactory}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentFavoritsBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity().applicationContext as App).provideAppComponent().inject(this)

        favAdapter = FavoritesAdapter()
        viewBinding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        viewBinding.recyclerView.adapter = favAdapter

        viewModel.getFavorites()


        viewModel.favorites.observe(viewLifecycleOwner){
            favAdapter.submitList(it)
        }
    }
}