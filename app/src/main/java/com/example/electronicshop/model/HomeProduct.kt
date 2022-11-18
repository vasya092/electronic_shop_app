package com.example.electronicshop.model

/**
 * HomeProduct - сущность, определяющая товары, которые
 * выводятся на главной странице в слайдере
 */

data class HomeProduct (
    val id: Long,
    val title: String,
    val picture: String,
    val subtitle: String,
    val is_buy: Boolean,
    val is_new: Boolean = false
)