package com.example.androidproject.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidproject.R
import com.example.androidproject.presentation.databinding.LoginFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.activity_container, LoginFragment())
        fragmentTransaction.commit()
    }
}