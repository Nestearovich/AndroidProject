package com.example.androidproject.presentation.auths

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.androidproject.R
import com.example.androidproject.databinding.FragmentOnBoardingBinding
import com.example.androidproject.presentation.home.ItemsFragment
import com.example.androidproject.utils.Navigation
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OnBoardingFragment : Fragment(),OnBoardinView {




    private var _viewBinding: FragmentOnBoardingBinding? = null
    private val viewBinding : FragmentOnBoardingBinding get() = _viewBinding!!

    @Inject
    lateinit var onBoardingPresenter: OnBoardingPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onBoardingPresenter.setView(this)

        viewBinding.btn1.setOnClickListener {
            onBoardingPresenter.goToItemsFragment()
        }


            }

    override fun goToItemsFragment() {
        Navigation.fmReplace(parentFragmentManager, ItemsFragment(), false)
    }
}

