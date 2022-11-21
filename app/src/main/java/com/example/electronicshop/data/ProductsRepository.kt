package com.example.electronicshop.data

import com.example.electronicshop.data.network.ProductsListResponse
import com.example.electronicshop.model.DetailProduct

interface ProductsRepository {
        suspend fun getAllProducts(): ProductsListResponse
        suspend fun getProductDetail(): DetailProduct
}