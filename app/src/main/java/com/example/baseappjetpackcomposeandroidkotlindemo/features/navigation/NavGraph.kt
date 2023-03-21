package com.example.baseappjetpackcomposeandroidkotlindemo.features.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.example.baseappjetpackcomposeandroidkotlindemo.features.component.RickAndMortyBottomAppBar
import com.example.baseappjetpackcomposeandroidkotlindemo.features.component.RickAndMortyFloatingActionBar
import com.example.baseappjetpackcomposeandroidkotlindemo.features.component.RickAndMortyScaffold
import com.example.baseappjetpackcomposeandroidkotlindemo.features.screen.home.navigation.homeNavigationRoute
import com.example.baseappjetpackcomposeandroidkotlindemo.features.screen.home.navigation.homeScreen
import com.example.baseappjetpackcomposeandroidkotlindemo.features.screen.store.navigation.episodesScreen
import com.example.baseappjetpackcomposeandroidkotlindemo.features.screen.favorites.navigation.favoritesScreen
import com.example.baseappjetpackcomposeandroidkotlindemo.features.screen.news.navigation.newsScreen
import com.example.baseappjetpackcomposeandroidkotlindemo.features.screen.settings.navigation.settingsScreen
import kotlinx.coroutines.launch

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavGraph() {

    val navController = rememberAnimatedNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val currentDestination = navController
        .currentBackStackEntryAsState().value?.destination
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()

    RickAndMortyScaffold(
        scaffoldState = scaffoldState,
        bottomBar = {
            BottomNav.values().forEach { navItem ->
                if (navItem.route == currentRoute) {
                    RickAndMortyBottomAppBar(
                        navController = navController,
                        currentDestination = currentDestination
                    )
                }
            }
        },
        floatingActionButton = {
            BottomNav.values().forEach { navItem ->
                if (navItem.route == currentRoute) {
                    RickAndMortyFloatingActionBar()
                }
            }
        },
        backgroundColor = MaterialTheme.colors.background,
    ) { innerPadding ->
        AnimatedNavHost(
            navController = navController,
            startDestination = homeNavigationRoute,
            Modifier.padding(innerPadding)
        ) {
            homeScreen()
            episodesScreen()
            newsScreen {
                scope.launch {
                    scaffoldState.snackbarHostState.showSnackbar(it?.name.toString())
                }
            }
            settingsScreen()
            favoritesScreen()
        }
    }
}
