package com.example.wish.feature.wishlist.domain.model

data class Product(
    val id: Int,
    val name: String,
    val isWishlisted: Boolean = false
)