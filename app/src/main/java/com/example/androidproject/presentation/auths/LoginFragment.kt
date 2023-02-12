package com.example.androidproject.presentation.auths

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.androidproject.App
import com.example.androidproject.databinding.FragmentLoginBinding
import com.example.androidproject.utils.NavHelper.navigateWithDeletedBackStack


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

    }
        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            (requireActivity().applicationContext as App).provideAppComponent().inject(this)

            binding.btnLog.setOnClickListener {
                viewModel.loginUser(
                    binding.edit1.text.toString(),
                    binding.edit2.text.toString()
                )
            }
            viewModel.nav.observe(viewLifecycleOwner) {
                if (it != null) {
                    navigateWithDeletedBackStack(
                        it.destinationId,
                        it.removeFragment
                    )
                    viewModel.userNavigated()
                }
            }

        }

}