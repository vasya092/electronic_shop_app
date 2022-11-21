package com.example.electronicshop.model

data class DetailProduct (
    val CPU: String,
    val camera: String,
    val capacity: List<String> = listOf(),
    val color: List<String> = listOf(),
    val id: Long,
    val images: List<String> = listOf(),
    val isFavorites: Boolean,
    val price: Int,
    val rating: Double,
    val sd: String,
    val ssd: String,
    val title: String
)
