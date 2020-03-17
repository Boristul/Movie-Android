package com.redmadrobot.authorization.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.redmadrobot.authorization.domain.usecase.LoginUseCase
import com.redmadrobot.core.ui.BaseViewModel
import javax.inject.Inject

class LoginFragmentViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : BaseViewModel() {

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

    fun loginButtonClicked() = loginUseCase.login(login, password)
}
