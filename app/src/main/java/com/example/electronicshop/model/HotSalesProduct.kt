package com.example.electronicshop.model

data class HotSalesProduct (
    val id: Long,
    val title: String,
    val picture: String,
    val subtitle: String,
    val is_buy: Boolean
)