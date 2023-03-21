@file:OptIn(ExperimentalAnimationApi::class)

package com.example.baseappjetpackcomposeandroidkotlindemo.features.screen.favorites.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.composable

const val favoritesNavigationRoute = "favorites_route"

fun NavGraphBuilder.favoritesScreen() {
    composable(
        favoritesNavigationRoute,
        content = {}
    )
}