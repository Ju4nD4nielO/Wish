package com.example.wish

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.wish.feature.wishlist.presentation.WishlistViewModel
import com.example.wish.navigation.appNavGraph
import com.example.wish.ui.theme.WishTheme
import androidx.navigation.compose.NavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WishTheme {
                val navController = rememberNavController()
                val sharedViewModel: WishlistViewModel = viewModel()

                NavHost(
                    navController = navController,
                    startDestination = "root"
                ) {
                    appNavGraph(
                        navController = navController,
                        sharedViewModel = sharedViewModel
                    )
                }
            }
        }
    }
}