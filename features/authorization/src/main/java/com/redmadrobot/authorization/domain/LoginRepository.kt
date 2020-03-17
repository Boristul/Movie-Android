package com.redmadrobot.authorization.domain

interface LoginRepository {
    fun login(email: String, password: String)
}