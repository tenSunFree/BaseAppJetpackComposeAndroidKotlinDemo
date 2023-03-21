@file:OptIn(ExperimentalAnimationApi::class)

package com.example.baseappjetpackcomposeandroidkotlindemo.features.screen.news.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import com.google.accompanist.navigation.animation.composable
import com.example.baseappjetpackcomposeandroidkotlindemo.data.model.dto.CharacterDto
import com.example.baseappjetpackcomposeandroidkotlindemo.features.screen.news.NewsScreen

const val newsNavigationRoute = "news_route"

fun NavController.navigateToNews(
    navOptions: NavOptions? = null
) {
    this.navigate(newsNavigationRoute, navOptions)
}

fun NavGraphBuilder.newsScreen(navigateToDetail: (CharacterDto?) -> Unit) {
    composable(newsNavigationRoute) {
        NewsScreen(
            hiltViewModel(),
            navigateToDetail = {
                navigateToDetail.invoke(it)
            }
        )
    }
}