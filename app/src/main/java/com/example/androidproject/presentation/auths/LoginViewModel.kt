package com.example.androidproject.presentation.auths

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidproject.R
import com.example.androidproject.domain.auth.AuthInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authInteractor: AuthInteractor
): ViewModel() {

    private val _nav = MutableLiveData<Int?>()
    val nav: LiveData<Int?> = _nav


    fun loginUser(userName: String, userPassword: String) {

        val coroutineExceptionHandler = CoroutineExceptionHandler{_, exseption ->
            Log.w("exceptionHandler" , exseption.toString())
        }

        viewModelScope.launch(CoroutineName("with exception") + Dispatchers.Main + coroutineExceptionHandler)  {
            try {
                authInteractor.loginUser(userName, userPassword)
                _nav.value = R.id.action_loginFragment_to_homeFragment
            }catch (e: Exception){
                Log.w("exception", "loginUser FAILED")
            }

        }
    }

    fun userNavigated(){
        _nav.value = null
    }
}