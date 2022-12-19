package com.example.androidproject.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import com.example.androidproject.R
import com.example.androidproject.databinding.ActivityMainBinding
import com.example.androidproject.presentation.auths.LoginFragment
import com.example.androidproject.presentation.home.HomeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(_binding!!.root)


        viewModel.checkUserExists()

        viewModel.userExists.observe(this){
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.activity_container,
                when(it){
                    true ->HomeFragment()
                    false ->LoginFragment()
                })
            fragmentTransaction.commit()
        }

    }
}