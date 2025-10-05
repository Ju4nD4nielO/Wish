package com.example.wish.feature.Wishlist.domain.model

data class Product(
    val id: Int,
    val name: String,
    val isWishlisted: Boolean = false
)