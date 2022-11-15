package com.example.electronicshop

import android.app.Application
import com.example.electronicshop.di.AppComponent
import com.example.electronicshop.di.DaggerAppComponent

open class BaseApplication: Application() {
    val appComponent: AppComponent by lazy{
        DaggerAppComponent.factory().create(applicationContext)
    }
}