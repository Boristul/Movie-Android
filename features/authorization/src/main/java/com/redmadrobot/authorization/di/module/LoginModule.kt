package com.redmadrobot.authorization.di.module

import com.redmadrobot.authorization.data.LoginRepositoryImpl
import com.redmadrobot.authorization.domain.LoginRepository
import dagger.Module
import dagger.Provides

@Module
class LoginModule {

    @Provides
    fun provideLoginRepository(): LoginRepository {
        return LoginRepositoryImpl()
    }
}
