package com.redmadrobot.movieandroid.ui.main.init.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.redmadrobot.repository.login.LoginRepository
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class LoginFragmentViewModel(application: Application) : AndroidViewModel(application), KodeinAware {
    override val kodein by kodein()
    private val loginRepository: LoginRepository by instance()

    private var login = ""
    private var password = ""

    private val isDataEnteredPrivate = MutableLiveData<Boolean>()
    val isDataEntered: LiveData<Boolean> get() = isDataEnteredPrivate

    fun updateLogin(login: String) {
        this.login = login
        updateIsDataEntered()
    }

    fun updatePassword(password: String) {
        this.password = password
        updateIsDataEntered()
    }

    private fun updateIsDataEntered() {
        isDataEnteredPrivate.value = login.isNotEmpty() && password.isNotEmpty()
    }

    fun login() = loginRepository.login(login, password)
}
