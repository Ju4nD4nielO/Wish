package com.example.wish.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.wish.feature.profile.presentation.ProfileScreen
import com.example.wish.feature.wishlist.presentation.WishlistScreen
import com.example.wish.feature.wishlist.presentation.WishlistViewModel

fun NavGraphBuilder.appNavGraph(
    navController: NavHostController,
    sharedViewModel: WishlistViewModel
) {
    navigation(
        startDestination = WISHLIST_ROUTE,
        route = ROOT_GRAPH_ROUTE
    ) {
        composable(route = WISHLIST_ROUTE) {
            WishlistScreen(
                onNavigateToProfile = {
                    navController.navigate(PROFILE_ROUTE)
                },
                viewModel = sharedViewModel
            )
        }
        composable(route = PROFILE_ROUTE) {
            ProfileScreen(
                onNavigateBack = { navController.popBackStack() },
                viewModel = sharedViewModel
            )
        }
    }
}