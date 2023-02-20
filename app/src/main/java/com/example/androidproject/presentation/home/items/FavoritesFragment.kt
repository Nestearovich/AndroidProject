package com.example.androidproject.presentation.home.items

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidproject.App
import com.example.androidproject.databinding.FragmentFavoritsBinding
import com.example.androidproject.presentation.home.items.adapter.FavoritesAdapter
import com.example.androidproject.presentation.receiver.AirplaneModeChangeReceiver
import com.example.androidproject.presentation.receiver.MyBroadcastReceiver
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


        val receiver = AirplaneModeChangeReceiver()
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            requireContext().registerReceiver(receiver, it)
        }

       val receiver2 = MyBroadcastReceiver()
        IntentFilter("MY_ACTION").also {
            requireContext().registerReceiver(receiver2, it)
        }

        setMessage()

        favAdapter = FavoritesAdapter()
        viewBinding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        viewBinding.recyclerView.adapter = favAdapter

        viewModel.getFavorites()


        viewModel.favorites.observe(viewLifecycleOwner){
            favAdapter.submitList(it)
        }
    }
    private fun setMessage(){
        val intent = Intent("MY_ACTION")
        intent.putExtra("KEY", "message")
        requireContext().sendBroadcast(intent)
    }
}