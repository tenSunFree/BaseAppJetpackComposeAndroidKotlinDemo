package com.example.baseappjetpackcomposeandroidkotlindemo.domain.repository

import com.example.baseappjetpackcomposeandroidkotlindemo.data.model.CharacterResponse
import com.example.baseappjetpackcomposeandroidkotlindemo.data.model.FavoriteEntity

interface CharacterRepository {
    suspend fun getAllCharacters(page: Int, options: Map<String, String>): CharacterResponse
    suspend fun getFavorite(favoriteId: Int): FavoriteEntity? = null
    suspend fun deleteFavoriteById(favoriteId: Int): Unit
    suspend fun saveFavorite(entity: FavoriteEntity): Unit
}