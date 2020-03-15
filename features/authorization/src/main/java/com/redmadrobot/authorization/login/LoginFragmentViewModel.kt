package com.redmadrobot.authorization.login

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

    // Спорно, в таких случаях возможно еще использование LiveData, но в данном ключе пока не имеет большого смысла.
    // Тем более с учетом того, что на лекциях рассказывалось про минимальное использование LiveData.
    private var login = ""
    private var password = ""

    private val isDataValidPrivate = MutableLiveData<Boolean>()
    val isDataValid: LiveData<Boolean> get() = isDataValidPrivate

    fun updateLogin(login: String) {
        this.login = login
        updateIsDataValid()
    }

    fun updatePassword(password: String) {
        this.password = password
        updateIsDataValid()
    }

    private fun updateIsDataValid() {
        isDataValidPrivate.value = login.isNotEmpty() && password.isNotEmpty()
    }

    fun login() = loginRepository.login(login, password)
}
