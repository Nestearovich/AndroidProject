package com.example.androidproject.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import com.example.androidproject.R
import com.example.androidproject.databinding.FragmentOnBoardingBinding


class OnBoardingFragment : Fragment() {


    private val viewModel: OnBoardingViewModel by viewModels()

    private var _viewBinding: FragmentOnBoardingBinding? = null
    private val viewBinding : FragmentOnBoardingBinding get() = _viewBinding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       viewBinding.viewModel = viewModel
        viewBinding.lifecycleOwner = viewLifecycleOwner


      

        viewModel.nav.observe(viewLifecycleOwner) {
            if (it != null) {
                Navigation.fmReplace(parentFragmentManager, ItemsFragment(), false)
                viewModel.finishPerformed()
            }
        }
    }
}