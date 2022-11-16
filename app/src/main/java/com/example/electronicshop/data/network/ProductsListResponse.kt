package com.example.electronicshop.data.network

import com.example.electronicshop.model.BestSellerProduct
import com.example.electronicshop.model.HomeProduct

data class ProductsListResponse(
    val home_store: List<HomeProduct>,
    val best_seller: List<BestSellerProduct>
)
