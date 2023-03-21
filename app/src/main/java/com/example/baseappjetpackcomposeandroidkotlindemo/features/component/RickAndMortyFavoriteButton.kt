package com.example.baseappjetpackcomposeandroidkotlindemo.features.component

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import com.example.baseappjetpackcomposeandroidkotlindemo.data.model.dto.CharacterDto
import com.example.baseappjetpackcomposeandroidkotlindemo.features.ui.theme.Gray500
import com.example.baseappjetpackcomposeandroidkotlindemo.utils.Utility.getAnimateFloat
import kotlinx.coroutines.delay

@Composable
fun RickAndMortyFavoriteButton(
    dto: CharacterDto,
    onTriggerEvent: (CharacterDto) -> Unit
) {
    var isFavorite by rememberSaveable(dto) { mutableStateOf(dto.isFavorite) }
    var isClick by remember { mutableStateOf(false) }
    LaunchedEffect(isClick) {
        if (isClick) {
            delay(800)
            isClick = false
        }
    }
    IconButton(onClick = {
        isClick = true
        isFavorite = !isFavorite
        dto.isFavorite = isFavorite
        onTriggerEvent.invoke(dto)
    }) {
        val tintColor = if (isFavorite) Red else Gray500

        Icon(
            modifier = Modifier.size(if (isClick) getAnimateFloat().value.dp else 24.dp),
            painter = rememberVectorPainter(Icons.Default.Favorite),
            contentDescription = null,
            tint = tintColor
        )
    }
}
