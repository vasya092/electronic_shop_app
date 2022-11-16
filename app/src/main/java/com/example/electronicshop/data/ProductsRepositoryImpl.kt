package com.example.electronicshop.data

import com.example.electronicshop.data.network.ProductsListResponse
import com.example.electronicshop.data.network.ShopApi

class ProductsRepositoryImpl(): ProductsRepository{
    override suspend fun getAllProducts(): ProductsListResponse {
        return ShopApi.retrofitService.getProducts()
    }

}