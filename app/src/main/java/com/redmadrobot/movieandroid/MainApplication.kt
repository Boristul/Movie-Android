package com.redmadrobot.movieandroid

import android.app.Application
import com.redmadrobot.repository.repositoryModule
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware

class MainApplication : Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(repositoryModule())
    }
}
