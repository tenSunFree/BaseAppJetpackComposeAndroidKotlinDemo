package com.example.baseappjetpackcomposeandroidkotlindemo.domain.viewstate.characters

import androidx.compose.runtime.Stable
import androidx.paging.PagingData
import com.example.baseappjetpackcomposeandroidkotlindemo.data.model.dto.CharacterDto
import com.example.baseappjetpackcomposeandroidkotlindemo.domain.viewstate.IViewState
import kotlinx.coroutines.flow.Flow

@Stable
data class CharactersViewState(
    val isLoading: Boolean = false,
    val pagedData: Flow<PagingData<CharacterDto>>? = null,
) : IViewState