package com.example.androidproject.presentation.home.items

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.annotation.RequiresApi
import androidx.fragment.app.viewModels
import com.example.androidproject.databinding.FragmentSearchBinding
import com.example.androidproject.presentation.home.items.service.MusicPlayer
import com.squareup.picasso.Picasso
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

    @RequiresApi(Build.VERSION_CODES.O)
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
            Picasso.get().load(Uri.parse(it.image)).into(viewBinding.image)
        }

        viewBinding.btnStart.setOnClickListener {
            requireActivity().startForegroundService(Intent(requireContext(),MusicPlayer::class.java))
        }


        viewBinding.btnStop.setOnClickListener {
            requireActivity().stopService(Intent(requireContext(),MusicPlayer::class.java))
        }
    }

}


