package com.example.androidproject.presentation.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.androidproject.R

object Navigation {
   fun fmReplace(
        parentFragmentManager: FragmentManager,
        fragment: Fragment,
        addToBackStack: Boolean,
    ) {
        if (addToBackStack) {
            parentFragmentManager
                .beginTransaction()
                .addToBackStack("")
                .replace(R.id.activity_container, fragment)
                .commit()
        } else {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.activity_container, fragment)
                .commit()
        }

    }
}