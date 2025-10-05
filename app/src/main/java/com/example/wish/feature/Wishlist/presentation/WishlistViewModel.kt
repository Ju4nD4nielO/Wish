package com.example.wish.feature.Wishlist.presentation

import androidx.lifecycle.ViewModel
import com.example.wish.feature.Wishlist.domain.model.Product
import com.example.wish.feature.Wishlist.domain.model.WishlistUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class WishlistViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(WishlistUiState())
    val uiState: StateFlow<WishlistUiState> = _uiState.asStateFlow()

    init {
        loadProducts()
    }

    fun loadProducts() {
        val products = listOf(
            Product(1, "Laptop Gaming ASUS ROG", false),
            Product(2, "iPhone 15 Pro Max", false),
            Product(3, "Samsung Galaxy S24 Ultra", false),
            Product(4, "iPad Pro 12.9\"", false),
            Product(5, "Sony WH-1000XM5 Auriculares", false),
            Product(6, "Apple Watch Series 9", false),
            Product(7, "Nintendo Switch OLED", false),
            Product(8, "PlayStation 5", false),
            Product(9, "MacBook Pro M3", false),
            Product(10, "AirPods Pro (2da Gen)", false)
        )

        _uiState.update { currentState ->
            currentState.copy(products = products)
        }
    }

    fun toggleWishlist(productId: Int) {
        _uiState.update { currentState ->
            val updatedProducts = currentState.products.map { product ->
                if (product.id == productId) {
                    product.copy(isWishlisted = !product.isWishlisted)
                } else {
                    product
                }
            }
            currentState.copy(products = updatedProducts)
        }
    }
}