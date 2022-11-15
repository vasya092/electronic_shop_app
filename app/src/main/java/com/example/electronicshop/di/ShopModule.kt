package com.example.electronicshop.di

import com.example.electronicshop.data.ProductsRepository
import com.example.electronicshop.data.ProductsRepostoryImpl
import dagger.Module
import dagger.Provides

@Module
class ShopModule {
    @Provides
    fun provideProductsRepository() : ProductsRepository = ProductsRepostoryImpl()
}