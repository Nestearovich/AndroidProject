package com.example.androidproject.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.androidproject.R
import com.example.androidproject.databinding.FragmentOnBoardingBinding

class OnBoardingFragment : Fragment() {
private var _viewBinding:FragmentOnBoardingBinding? = null
    private val viewBinding get() = _viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _viewBinding = FragmentOnBoardingBinding.inflate(inflater)
        return viewBinding.root

        //return inflater.inflate(R.layout.fragment_on_boarding, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


       // val onBordingFinish = view.findViewById<Button>(R.id.btn1)


        viewBinding.btnFinish.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.activity_container, ItemsFragment())
                .commit()
        }
    }
}