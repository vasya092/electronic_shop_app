package com.example.electronicshop.model

data class CartData (
    val basket: List<BasketItem>,
    val delivery: String,
    val id: Long,
    val total: Int
    )