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
import javax.inject.Inject

@AndroidEntryPoint
class DetailFragment : Fragment(),DetailView {


    private var _viewBinding: FragmentDetailBinding? = null
    private val viewBinding get() = _viewBinding !!

   @Inject
   lateinit var detailPresenter: DetailPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentDetailBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        detailPresenter.setView(this)


        val bundle = arguments
        bundle?.let{ safeBundle ->
            detailPresenter.getArguments(
                bundle.getString(NAME),
                    bundle.getString(DATE),
                    bundle.getInt(IMAGE))

//            detailsName.text = name
//            detailsDate.text = date
//            detailsImage.setBackgroundResource(image)
        }


        viewBinding.btnLogout.setOnClickListener {
            detailPresenter.logoutUser()
        }


    }

    override fun userLoggedOut() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.activity_container,LoginFragment())
            .commit()
    }

    override fun disolayItemData(name: String, date: String, imageView: Int) {
        viewBinding.textView3.text = name
        viewBinding.textView4.text = date
        viewBinding.imageView.setBackgroundResource(imageView)
    }
}
