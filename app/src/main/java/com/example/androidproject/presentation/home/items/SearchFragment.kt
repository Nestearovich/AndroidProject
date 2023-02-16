package com.example.androidproject.presentation.home.items

import android.content.Intent
import android.database.Observable
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.androidproject.App
import com.example.androidproject.R
import com.example.androidproject.databinding.FragmentSearchBinding
import com.example.androidproject.presentation.home.items.service.MusicPlayer
import com.example.androidproject.utils.BaseFragment
import com.example.androidproject.utils.rx.RxJavaExsample
import com.squareup.picasso.Picasso
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.AsyncSubject
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.ReplaySubject


class SearchFragment : BaseFragment() {


    private var _viewBinding: FragmentSearchBinding? = null
    private val viewBinding get() = _viewBinding!!

    private val viewModel: SearchViewModel by viewModels { viewModelFactory }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentSearchBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity().applicationContext as App).provideAppComponent().inject(this)


        RxJavaExsample().observableJust1()

        RxJavaExsample().observableJust2()

        RxJavaExsample().observableFlatmap()

        RxJavaExsample().observableZip()

        RxJavaExsample().observableConcat()

        RxJavaExsample().observableCreate()





        val publishSubject2 = ReplaySubject.create<Int>()
        publishSubject2.onNext(1)
        publishSubject2.onNext(2)
        publishSubject2.onNext(3)
        publishSubject2.subscribe({Log.w("publish value",it.toString())})
        publishSubject2.onNext(4)
        publishSubject2.onNext(5)
        publishSubject2.subscribe({Log.w("publish value2",it.toString())})


        val publishSubject3 = BehaviorSubject.create<Int>()
        publishSubject3.onNext(1)
        publishSubject3.onNext(2)
        publishSubject3.onNext(3)
        publishSubject3.subscribe({Log.w("publish value",it.toString())})
        publishSubject3.onNext(4)
        publishSubject3.subscribe({Log.w("publish value2",it.toString())})
        publishSubject3.onNext(5)

        val asyncSubject = AsyncSubject.create<Int>()
        asyncSubject.onNext(1)
        asyncSubject.onNext(2)
        asyncSubject.onNext(3)
        asyncSubject.subscribe({Log.w("publish value",it.toString())})
        asyncSubject.onNext(4)
        asyncSubject.subscribe({Log.w("publish value2",it.toString())})
        asyncSubject.onNext(5)
        asyncSubject.onComplete()




        viewBinding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                viewModel.findItem(p0 ?: "")
                return false
            }


        })
        viewModel.items.observe(viewLifecycleOwner) {
            viewBinding.description.text = it.description
            Picasso.get().load(Uri.parse(it.image)).into(viewBinding.image)
        }



        viewBinding.btnStart.setOnClickListener {
            requireActivity().startService(Intent(requireContext(), MusicPlayer::class.java))
        }

        viewBinding.btnStop.setOnClickListener {
            requireActivity().stopService(Intent(requireContext(), MusicPlayer::class.java))
        }
    }
}


