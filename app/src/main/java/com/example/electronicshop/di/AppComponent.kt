package com.example.electronicshop.di

import android.content.Context
import com.example.electronicshop.ui.HomeFragment
import dagger.BindsInstance
import dagger.Component

@Component(modules = [ShopModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(fragment: HomeFragment)
}
