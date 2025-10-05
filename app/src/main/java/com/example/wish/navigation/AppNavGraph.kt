package com.example.wish.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.wish.feature.profile.presentation.ProfileScreen
import com.example.wish.feature.wishlist.presentation.WishlistScreen

fun NavGraphBuilder.appNavGraph(navController: NavHostController) {
    navigation(
        startDestination = WISHLIST_ROUTE,
        route = ROOT_GRAPH_ROUTE
    ) {
        composable(WISHLIST_ROUTE) {
            WishlistScreen(
                onNavigateToProfile = {
                    navController.navigate(PROFILE_ROUTE)
                }
            )
        }
        composable(PROFILE_ROUTE) {
            ProfileScreen(
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}