package com.redmadrobot.repository

import com.redmadrobot.repository.login.LoginRepositoryImpl
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton
import org.kodein.di.weakReference

fun repositoryModule() = Kodein.Module(name = "Repository") {
    bind() from singleton(ref = weakReference) { LoginRepositoryImpl() }
}
