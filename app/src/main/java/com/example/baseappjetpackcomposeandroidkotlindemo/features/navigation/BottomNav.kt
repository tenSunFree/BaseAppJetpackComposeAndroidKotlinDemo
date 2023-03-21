package com.example.baseappjetpackcomposeandroidkotlindemo.features.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.baseappjetpackcomposeandroidkotlindemo.R
import com.example.baseappjetpackcomposeandroidkotlindemo.features.screen.home.navigation.homeNavigationRoute
import com.example.baseappjetpackcomposeandroidkotlindemo.features.screen.store.navigation.storeNavigationRoute
import com.example.baseappjetpackcomposeandroidkotlindemo.features.screen.favorites.navigation.favoritesNavigationRoute
import com.example.baseappjetpackcomposeandroidkotlindemo.features.screen.news.navigation.newsNavigationRoute
import com.example.baseappjetpackcomposeandroidkotlindemo.features.screen.settings.navigation.memberNavigationRoute

enum class BottomNav(
    val route: String,
    @DrawableRes val iconId: Int,
    @StringRes val titleTextId: Int
) {
    HOME(
        homeNavigationRoute,
        R.drawable.ic_home,
        R.string.characters_screen_title,
    ),
    STORE(
        storeNavigationRoute,
        R.drawable.ic_store,
        R.string.episodes_screen_title
    ),
    FAVORITES(
        favoritesNavigationRoute,
        R.drawable.ic_baseline_favorite_24,
        R.string.favorite_screen_title,
    ),
    NEWS(
        newsNavigationRoute,
        R.drawable.ic_news,
        R.string.search_screen_title,
    ),
    MEMBER(
        memberNavigationRoute,
        R.drawable.ic_member,
        R.string.settings_screen_title
    )
}