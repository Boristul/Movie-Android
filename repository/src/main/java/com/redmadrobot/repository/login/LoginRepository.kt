package com.redmadrobot.repository.login

interface LoginRepository {
    fun login(login: String, password: String)
}
