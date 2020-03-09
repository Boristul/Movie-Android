package com.redmadrobot.repository.login

import android.util.Log

class LoginRepositoryImpl : LoginRepository {
    override fun login(login: String, password: String) {
        Log.d("login", "Enter login: $login, password: $password")
    }
}
