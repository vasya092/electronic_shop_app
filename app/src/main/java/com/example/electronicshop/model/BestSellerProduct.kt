package com.example.electronicshop.model

data class BestSellerProduct(
    val id: Long,
    val title: String,
    val picture: String,
    val is_favorites: Boolean,
    val price_without_discount: Int,
    val discount_price: Int,
)
