package com.example.baseappjetpackcomposeandroidkotlindemo.features.screen.news

import com.example.baseappjetpackcomposeandroidkotlindemo.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.MaterialTheme
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.baseappjetpackcomposeandroidkotlindemo.data.model.dto.CharacterDto
import com.example.baseappjetpackcomposeandroidkotlindemo.features.component.RickAndMortyCharacterShimmer
import com.example.baseappjetpackcomposeandroidkotlindemo.features.component.RickAndMortyScaffold
import com.example.baseappjetpackcomposeandroidkotlindemo.utils.Utility.rememberFlowWithLifecycle
import kotlinx.coroutines.flow.Flow

@Composable
fun NewsScreen(
    viewModel: NewsViewModel,
    navigateToDetail: (CharacterDto?) -> Unit
) {
    val scaffoldState = rememberScaffoldState()
    val viewState = viewModel.uiState.collectAsState().value

    RickAndMortyScaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        content = {
            Content(
                isLoading = viewState.isLoading,
                pagedData = viewState.pagedData,
                onTriggerEvent = {
                    viewModel.onTriggerEvent(it)
                },
                clickDetail = {
                    navigateToDetail.invoke(it)
                }
            )
        },
        backgroundColor = MaterialTheme.colors.background
    )
}

@Composable
private fun Content(
    isLoading: Boolean = false,
    pagedData: Flow<PagingData<CharacterDto>>? = null,
    onTriggerEvent: (CharactersViewEvent) -> Unit,
    clickDetail: (CharacterDto?) -> Unit
) {
    var pagingItems: LazyPagingItems<CharacterDto>? = null
    pagedData?.let {
        pagingItems = rememberFlowWithLifecycle(it).collectAsLazyPagingItems()
    }
    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Image(
            painter = painterResource(id = R.drawable.icon_news_top_bar),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(4.9f),
        )
        LazyVerticalGrid(
            contentPadding = PaddingValues(vertical = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.padding(horizontal = 15.dp),
            columns = GridCells.Fixed(2)
        ) {
            if (isLoading) {
                items(count = 10) {
                    RickAndMortyCharacterShimmer()
                }
            } else if (pagedData != null && pagingItems != null) {
                items(count = pagingItems!!.itemCount) { count ->
                    NewsCard(
                        detailClick = {
                            clickDetail.invoke(pagingItems!![count])
                        },
                        dto = pagingItems!![count],
                        onTriggerEvent = {
                            onTriggerEvent.invoke(CharactersViewEvent.UpdateFavorite(it))
                        }
                    )
                }
            }
        }
    }
}