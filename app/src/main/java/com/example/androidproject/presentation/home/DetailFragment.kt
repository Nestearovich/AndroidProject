package com.example.androidproject.presentation.home


import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.androidproject.utils.BundleConstant.IMAGE
import com.example.androidproject.R
import com.example.androidproject.databinding.FragmentDetailBinding
import com.example.androidproject.utils.BundleConstant.DATE
import com.example.androidproject.utils.BundleConstant.NAME
import com.example.androidproject.utils.NavHelper.replaceGraph
import com.squareup.picasso.Picasso
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
            val description = safeBundle.getString("description")
            val image = safeBundle.getString(IMAGE)


            viewBinding.textView3.text = description
            Picasso.get().load(Uri.parse(image)).into(viewBinding.imageView)

        }

        viewBinding.btnLogout.setOnClickListener {
            viewModel.logoutUser()
        }

        viewModel.nav.observe(viewLifecycleOwner) {
            if (it != null) {
                val navGraph = findNavController().navInflater.inflate(it)

                navGraph.startDestination = R.id.loginFragment
                findNavController().graph = navGraph
            }
        }
    }
}
