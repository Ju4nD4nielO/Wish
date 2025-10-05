package com.example.wish

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.wish.feature.Wishlist.presentation.WishlistScreen
import com.example.wish.feature.likeCounter.presentation.LikeCounterScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                // 🧩 Cambia entre Parte 1 y Parte 2 comentando/descomentando:

                // --- Parte 1 ---
                 //LikeCounterScreen()

                // --- Parte 2 ---
                WishlistScreen()
            }
        }
    }
}