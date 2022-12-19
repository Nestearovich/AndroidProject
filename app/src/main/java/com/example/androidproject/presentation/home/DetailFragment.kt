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
import com.example.androidproject.databinding.FragmentHomeBinding
import com.example.androidproject.presentation.auths.LoginFragment
import com.example.androidproject.utils.BundleConstant.DATE
import com.example.androidproject.utils.BundleConstant.NAME
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {


    private var _viewBinding: FragmentDetailBinding? = null
    private val viewBinding get() = _viewBinding !!

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

        val detailsName = view.findViewById<TextView>(R.id.textView3)
        val detailsDate = view.findViewById<TextView>(R.id.textView4)
        val detailsImage = view.findViewById<ImageView>(R.id.imageView)


        val bundle = arguments
        bundle?.let{ safeBundle ->
            val name = bundle.getString(NAME)
            val date = bundle.getString(DATE)
            val image = bundle.getInt(IMAGE)


            detailsName.text = name
            detailsDate.text = date
            detailsImage.setBackgroundResource(image)
        }

        viewBinding.nav.observe(viewLifecycleOwner){
            parentFragmentManager.beginTransaction()
                .replace(R.id.activity_container,LoginFragment())
                .commit()
        }
    }
}
