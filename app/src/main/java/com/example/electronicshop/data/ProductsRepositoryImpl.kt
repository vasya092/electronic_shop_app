package com.example.electronicshop.data

import com.example.electronicshop.data.network.ProductsListResponse
import com.example.electronicshop.data.network.ShopApi
import com.example.electronicshop.model.DetailProduct

class ProductsRepositoryImpl(): ProductsRepository{
    override suspend fun getAllProducts(): ProductsListResponse {
        return ShopApi.retrofitService.getProducts()
    }

    override suspend fun getProductDetail(): DetailProduct {
        return ShopApi.retrofitService.getProductDetail()
    }

}