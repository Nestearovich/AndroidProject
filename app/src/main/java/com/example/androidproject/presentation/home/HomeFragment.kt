package com.example.androidproject.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.androidproject.App
import com.example.androidproject.databinding.FragmentHomeBinding
import com.example.androidproject.utils.BaseFragment
import com.example.androidproject.utils.NavHelper.replaceGraph
import com.example.androidproject.utils.coroutines.CoroutinesExample


class HomeFragment : BaseFragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModels{viewModelFactory}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity().applicationContext as App).provideAppComponent().inject(this)

        CoroutinesExample().testCoroutinesCancel()

        viewModel.showUserData()

        binding.btnGoToOnBording.setOnClickListener {
          viewModel.goToOnBoarding()
        }

        viewModel.nav.observe(viewLifecycleOwner){
            if (it != null) {
                replaceGraph(it)
            }
        }

        viewModel.userCreds.observe(viewLifecycleOwner){
            binding.tvUserCreds.text = "${it.userName}\n${it.userPassword}"
        }
    }
}
