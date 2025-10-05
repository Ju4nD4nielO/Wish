package com.example.wish.feature.wishlist.domain.model

data class WishlistUiState(
    val products: List<Product> = emptyList()
) {
    val wishlistedCount: Int
        get() = products.count { it.isWishlisted }
}