package com.example.videomessages

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.example.videomessages.di.*
import com.readystatesoftware.chuck.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class App : Application() {

    companion object {
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())

        //Koin
        val modules = listOf(networkModule, helperModule, repositoryModule, useCase, viewModelModule, adapterModule)

        startKoin {
            androidLogger()
            androidContext(this@App)
            androidFileProperties()
            koin.loadModules(modules)
        }
    }
}