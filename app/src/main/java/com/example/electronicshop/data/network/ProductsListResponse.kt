package com.example.electronicshop.data.network

import com.example.electronicshop.model.BestSellerProduct
import com.example.electronicshop.model.HotSalesProduct

data class ProductsListResponse(
    val home_store: List<HotSalesProduct>,
    val best_seller: List<BestSellerProduct>
)
