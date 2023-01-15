package com.example.androidproject.data.authitems

import com.example.androidproject.data.sharedprefences.SharedPreferencesHelper
import com.example.androidproject.domain.auth.AuthRepository
import com.example.androidproject.domain.model.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val sharedPreferencesHelper: SharedPreferencesHelper,
): AuthRepository {

    override suspend fun loginUser(userName: String, userPassword: String) {
        withContext(Dispatchers.IO){
            sharedPreferencesHelper.saveUserName(userName)
            sharedPreferencesHelper.saveUserPassword(userPassword)

        }
    }

    override suspend fun showUserCreds(): UserModel {
        return withContext(Dispatchers.IO){
            sharedPreferencesHelper.getUserCreds()
        }
    }

    override suspend fun doesUserExist(): Boolean {
        return withContext(Dispatchers.IO){
            sharedPreferencesHelper.checkUserExists()
        }
    }

    override suspend fun userLogout() {
         withContext(Dispatchers.IO){
             sharedPreferencesHelper.removeUser()}
    }
}