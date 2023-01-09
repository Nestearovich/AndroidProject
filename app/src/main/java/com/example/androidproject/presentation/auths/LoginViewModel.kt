package com.example.androidproject.presentation.auths

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidproject.domain.auth.AuthInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authInteractor: AuthInteractor
): ViewModel() {

    private val _nav = MutableLiveData<Unit?>()
    val nav: LiveData<Unit?> = _nav

    fun loginUser(userName: String, userPassword: String) {
        val coroutineExseptionHandler = CoroutineExceptionHandler{_, exseption ->
            Log.w("exceptionHandler" , exseption.toString())
        }

        viewModelScope.launch(Dispatchers.Main) {
            try {
                authInteractor.loginUser(userName, userPassword)
                _nav.postValue(Unit)
            }catch (e: java.lang.Exception){
            }

        }
        Log.w("start","started")

        Log.w("finih","finished")
    }
}