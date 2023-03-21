package com.example.baseappjetpackcomposeandroidkotlindemo.features.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.valentinilk.shimmer.shimmer

@Composable
fun RickAndMortyCharacterShimmer(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = RoundedCornerShape(12.dp),
        elevation = 8.dp,
    ) {
        Column(
            modifier = Modifier
                .size(300.dp)
                .fillMaxWidth()
                .shimmer(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Box(
                modifier = Modifier
                    .height(200.dp)
                    .background(color = Color.LightGray)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp)),
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp)
                    .background(color = Color.LightGray)
            )
            RickAndMortyText(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.LightGray),
                text = "",
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.secondaryVariant
            )
            RickAndMortyText(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.LightGray),
                text = "",
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.secondaryVariant,
            )
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .background(color = Color.LightGray),
                contentAlignment = Alignment.CenterEnd
            ) {}
        }
    }
}