package com.example.androidproject.presentation.auths

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.androidproject.R
import com.example.androidproject.databinding.FragmentLoginBinding
import com.example.androidproject.utils.NavHelper.navigate
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginFragment : Fragment() {

    private val viewModel: LoginViewModel by viewModels()


    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root


        binding.button.setOnClickListener {
            viewModel.loginUser(
                binding.edit1.text.toString(),
                binding.edit2.text.toString()
            )
        }

        viewModel.nav.observe(viewLifecycleOwner) {
            if (it != null) {
                navigate(R.id.action_loginFragment_to_homeFragment)
                viewModel.userNavigated()
            }
        }
    }
}