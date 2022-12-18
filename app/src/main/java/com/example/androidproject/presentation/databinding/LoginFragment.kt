package com.example.androidproject.presentation.databinding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.androidproject.R
import com.example.androidproject.databinding.FragmentLoginBinding
import com.example.androidproject.presentation.view.Navigation.fmReplace
import com.example.androidproject.presentation.view.OnBoardingFragment


class LoginFragment : Fragment() {

    private val viewModel: LoginViewModel by viewModels()


    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding= FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root



        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        //binding.viewHandler = ViewHandler()
    }

    inner class ViewHandler{
        fun goToTheOnbording(){
            fmReplace(parentFragmentManager,OnBoardingFragment(),false)
        }
    }
}