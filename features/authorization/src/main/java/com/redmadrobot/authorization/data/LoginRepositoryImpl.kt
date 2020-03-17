package com.redmadrobot.authorization.data

import android.util.Log
import com.redmadrobot.authorization.domain.LoginRepository

class LoginRepositoryImpl : LoginRepository {
    override fun login(email: String, password: String) {
        Log.d("login", "Enter login: $email, password: $password")
    }
}
