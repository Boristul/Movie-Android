package com.redmadrobot.movieandroid.ui.main.init.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.redmadrobot.repository.login.LoginRepository
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class LoginFragmentViewModel(application: Application) : AndroidViewModel(application), KodeinAware {
    override val kodein by kodein()
    private val loginRepository: LoginRepository by instance()

    fun login(login: String, password: String) = loginRepository.login(login, password)
}
