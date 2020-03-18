package com.redmadrobot.authorization.domain.usecase

import com.redmadrobot.authorization.domain.LoginRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val loginRepository: LoginRepository) {
    fun login(email: String, password: String) = loginRepository.login(email, password)
}