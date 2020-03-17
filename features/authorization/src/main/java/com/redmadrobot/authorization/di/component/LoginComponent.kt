package com.redmadrobot.authorization.di.component

import com.redmadrobot.authorization.di.module.LoginModule
import com.redmadrobot.authorization.ui.login.LoginFragment
import dagger.Component

@Component(
    modules = [
        LoginModule::class
    ]
)
interface LoginComponent {

    fun inject(target: LoginFragment)

    class Builder private constructor() {
        companion object {
            fun build(): LoginComponent {
                return DaggerLoginComponent.builder()
                    .build()
            }
        }
    }
}
