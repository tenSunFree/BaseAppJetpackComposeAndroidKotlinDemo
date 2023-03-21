package com.example.baseappjetpackcomposeandroidkotlindemo.features.screen.news

import com.example.baseappjetpackcomposeandroidkotlindemo.R
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.baseappjetpackcomposeandroidkotlindemo.data.model.dto.CharacterDto
import com.example.baseappjetpackcomposeandroidkotlindemo.features.component.RickAndMortyFavoriteButton
import com.example.baseappjetpackcomposeandroidkotlindemo.features.component.RickAndMortyNetworkImage
import com.example.baseappjetpackcomposeandroidkotlindemo.features.component.RickAndMortyText

@Composable
fun NewsCard(
    modifier: Modifier = Modifier,
    dto: CharacterDto?,
    detailClick: () -> Unit,
    onTriggerEvent: (CharacterDto) -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable { detailClick() },
        shape = RoundedCornerShape(12.dp),
        elevation = 8.dp,
    ) {
        Column(
            modifier = Modifier
                .size(300.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            RickAndMortyNetworkImage(
                imageURL = dto?.image,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp)),
                placeholder = R.drawable.ic_place_holder,
                contentScale = ContentScale.Crop,
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp)
            )
            RickAndMortyText(
                text = dto?.name.orEmpty(),
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.secondaryVariant
            )
            RickAndMortyText(
                text = dto?.species.orEmpty(),
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.secondaryVariant,
            )
            Box(modifier = Modifier.fillMaxHeight(), contentAlignment = Alignment.CenterEnd) {
                dto?.let {
                    RickAndMortyFavoriteButton(
                        dto = it,
                        onTriggerEvent = { dto ->
                            onTriggerEvent.invoke(dto)
                        }
                    )
                }
            }
        }
    }
}