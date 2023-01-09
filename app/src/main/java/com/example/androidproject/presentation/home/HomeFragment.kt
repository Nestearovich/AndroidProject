package com.example.androidproject.presentation.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope

import com.example.androidproject.R
import com.example.androidproject.databinding.FragmentHomeBinding
import com.example.androidproject.presentation.auths.OnBoardingFragment

import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {



    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
           val job = launch {
                for (i in 1..5){
                    Log.w("called","$i")
                    delay(400)
                }
            }
            Log.w("start","started")
            Log.w("finish","finished")
        }

        viewModel.showUserData()

        binding.button2.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.activity_container,OnBoardingFragment())
                .commit()
        }

        viewModel.userCreds.observe(viewLifecycleOwner){
            binding.tvUserCreds.text = "${it.userName}\n${it.userPassword}"
        }
    }

}
