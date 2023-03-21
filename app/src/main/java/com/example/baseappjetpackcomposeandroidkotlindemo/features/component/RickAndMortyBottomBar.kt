package com.example.baseappjetpackcomposeandroidkotlindemo.features.component

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.navOptions
import androidx.tracing.trace
import com.example.baseappjetpackcomposeandroidkotlindemo.features.navigation.BottomNav
import com.example.baseappjetpackcomposeandroidkotlindemo.features.screen.home.navigation.navigateCharacter
import com.example.baseappjetpackcomposeandroidkotlindemo.features.screen.news.navigation.navigateToNews
import com.example.baseappjetpackcomposeandroidkotlindemo.features.screen.settings.navigation.navigateToSettings
import com.example.baseappjetpackcomposeandroidkotlindemo.features.screen.store.navigation.navigateToEpisodes

@Composable
fun RickAndMortyBottomAppBar(
    navController: NavController,
    currentDestination: NavDestination?,
) {
    BottomAppBar(
        modifier = Modifier
            .clip(
                RoundedCornerShape(
                    topStart = 30.dp,
                    topEnd = 30.dp
                )
            ),
        cutoutShape = CircleShape,
        elevation = 10.dp,
        backgroundColor = MaterialTheme.colors.onSecondary
    ) {
        BottomNav.values().forEach { screen ->
            val selected = currentDestination.isBottomNavDestinationInHierarchy(screen)
            val primary = MaterialTheme.colors.primary
            val secondary = MaterialTheme.colors.secondary
            BottomNavigationItem(
                alwaysShowLabel = true,
                selectedContentColor = primary,
                unselectedContentColor = secondary,
                icon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = screen.iconId),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                },
                label = {
                    RickAndMortyText(
                        text = if (screen.titleTextId == com.example.baseappjetpackcomposeandroidkotlindemo.R.string.favorite_screen_title) "" else stringResource(
                            id = screen.titleTextId
                        ),
                        color = if (selected) primary else secondary,
                        style = MaterialTheme.typography.overline,
                        textAlign = TextAlign.Center,
                        maxLines = 1
                    )
                },
                selected = selected,
                onClick = {
                    navigateToBottomNavDestination(screen, navController)
                }
            )
        }
    }
}

fun navigateToBottomNavDestination(bottomNav: BottomNav, navController: NavController) {
    trace("Navigation: ${bottomNav.name}") {
        val bottomNavOptions = navOptions {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            // Avoid multiple copies of the same destination when
            // reselecting the same item
            launchSingleTop = true
            // Restore state when reselecting a previously selected item
            restoreState = true
        }
        when (bottomNav) {
            BottomNav.HOME -> navController.navigateCharacter(bottomNavOptions)
            BottomNav.STORE -> navController.navigateToEpisodes(bottomNavOptions)
            // BottomNav.FAVORITES -> navController.navigateToFavorites(bottomNavOptions)
            BottomNav.FAVORITES -> {}
            BottomNav.NEWS -> navController.navigateToNews(bottomNavOptions)
            BottomNav.MEMBER -> navController.navigateToSettings(bottomNavOptions)
        }
    }
}

private fun NavDestination?.isBottomNavDestinationInHierarchy(destination: BottomNav) =
    this?.hierarchy?.any {
        it.route?.contains(destination.name, true) ?: false
    } ?: false
