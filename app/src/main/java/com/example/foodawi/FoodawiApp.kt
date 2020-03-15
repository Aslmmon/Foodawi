package com.example.foodawi

import android.app.Application
import android.content.Context
import com.example.foodawi.common.di.networkModule
import com.example.foodawi.common.di.repositoriesModule
import com.example.foodawi.common.di.sharedPref
import com.example.splasho.di.viewModelModule
import com.homyapplication.common.Utils
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class FoodawiApp : Application() {

    companion object {
        lateinit var context: Context
        fun getAppContext(): Context {
            return context
        }
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        startKoin {
            androidContext(this@FoodawiApp)
            androidLogger()
            modules(listOf(viewModelModule, networkModule, repositoriesModule, sharedPref))
        }
    }
}
