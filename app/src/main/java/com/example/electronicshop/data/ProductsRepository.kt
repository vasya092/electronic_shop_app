package com.example.electronicshop.data

import com.example.electronicshop.data.network.ProductsListResponse

interface ProductsRepository {
        suspend fun getAllProducts(): ProductsListResponse
}