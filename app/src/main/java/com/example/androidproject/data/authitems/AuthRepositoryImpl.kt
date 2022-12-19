package com.example.androidproject.data.authitems

import com.example.androidproject.data.sharedprefences.SharedPreferencesHelper
import com.example.androidproject.domain.auth.AuthRepository
import com.example.androidproject.domain.model.UserModel
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val sharedPreferencesHelper: SharedPreferencesHelper
): AuthRepository {

    override fun loginUser(userName: String, userPassword: String) {
        sharedPreferencesHelper.saveUserName(userName)
        sharedPreferencesHelper.saveUserPassword(userPassword)

    }

    override fun showUserCreds(): UserModel {
        return sharedPreferencesHelper.getUserCreds()
    }

    override fun doesUserExist(): Boolean {
        return sharedPreferencesHelper.checkUserExists()
    }

    override fun userLogout() {
        sharedPreferencesHelper.removeUser()
    }
}