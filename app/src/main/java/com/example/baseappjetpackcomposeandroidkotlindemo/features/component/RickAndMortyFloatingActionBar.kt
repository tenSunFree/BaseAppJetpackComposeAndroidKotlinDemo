package com.example.baseappjetpackcomposeandroidkotlindemo.features.component

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.baseappjetpackcomposeandroidkotlindemo.features.navigation.BottomNav
import com.example.baseappjetpackcomposeandroidkotlindemo.utils.Utility.getAnimateFloat
import kotlinx.coroutines.delay

@Composable
fun RickAndMortyFloatingActionBar() {
    var isClick by remember { mutableStateOf(false) }
    LaunchedEffect(isClick) {
        if (isClick) {
            delay(2000)
            isClick = false
        }
    }
    FloatingActionButton(
        onClick = { isClick = true },
        contentColor = Color.White,
        backgroundColor = MaterialTheme.colors.onSecondary,
        shape = CircleShape,
    ) {
        val screen = BottomNav.values()[2]
        Icon(
            imageVector = ImageVector.vectorResource(id = screen.iconId),
            contentDescription = null,
            tint = MaterialTheme.colors.primary,
            modifier = Modifier.size(if (isClick) getAnimateFloat().value.dp else 24.dp)
        )
    }
}
