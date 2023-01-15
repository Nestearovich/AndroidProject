package com.example.androidproject.presentation.home


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.viewModels
import com.example.androidproject.utils.BundleConstant.IMAGE
import com.example.androidproject.R
import com.example.androidproject.databinding.FragmentDetailBinding
import com.example.androidproject.utils.BundleConstant.DATE
import com.example.androidproject.utils.BundleConstant.NAME
import com.example.androidproject.utils.NavHelper.replaceGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {


    private var _viewBinding: FragmentDetailBinding? = null
    private val viewBinding get() = _viewBinding!!

    private val viewModel: DetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentDetailBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val bundle = arguments
        bundle?.let { safeBundle ->
            val name = bundle.getString(NAME)
            val date = bundle.getString(DATE)
            val image = bundle.getInt(IMAGE)


            viewBinding.textView3.text = name
            viewBinding.textView4.text = date
            viewBinding.imageView.setBackgroundResource(image)
        }

        viewBinding.btnLogout.setOnClickListener {
            viewModel.logoutUser()
        }

        viewModel.nav.observe(viewLifecycleOwner) {
            if (it != null) {
                replaceGraph(it)
            }
        }
    }
}
