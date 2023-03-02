package com.example.androidproject.presentation.home.items

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.androidproject.databinding.FragmentSearchBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {


    private var _viewBinding: FragmentSearchBinding? = null
    private val viewBinding get() = _viewBinding!!

    private val viewModel: SearchViewModel by viewModels ()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentSearchBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.search.setOnQueryTextListener(object: SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                viewModel.findItem(p0?:"")
                return false
            }

        })

        viewModel.items.observe(viewLifecycleOwner){
            viewBinding.description.text = it.descripstion
           // Picasso.get().load(Uri.parse(it.image)).into(viewBinding.image)
        }
    }
}


