package com.example.baseappjetpackcomposeandroidkotlindemo.data.remote.source

import com.example.baseappjetpackcomposeandroidkotlindemo.data.model.CharacterInfoResponse
import com.example.baseappjetpackcomposeandroidkotlindemo.data.model.CharacterResponse
import com.example.baseappjetpackcomposeandroidkotlindemo.data.model.FavoriteEntity
import com.example.baseappjetpackcomposeandroidkotlindemo.data.remote.utils.DataState
import kotlinx.coroutines.flow.Flow

interface CharacterRemoteDataSource {
    suspend fun getAllCharacters(page: Int, options: Map<String, String>): CharacterResponse
    suspend fun getFilterCharacters(page: Int, options: Map<String, String>): CharacterResponse
    suspend fun getCharacter(characterId: Int): Flow<DataState<CharacterInfoResponse>>
    suspend fun getCharacter(url: String): Flow<DataState<CharacterInfoResponse>>
    suspend fun getFavoriteList(): List<FavoriteEntity>
    suspend fun getFavorite(favoriteId: Int): FavoriteEntity? = null
    suspend fun deleteFavoriteById(favoriteId: Int): Unit
    suspend fun deleteFavoriteList(): Unit
    suspend fun saveFavorite(entity: FavoriteEntity): Unit
    suspend fun saveFavoriteList(entityList: List<FavoriteEntity>): Unit
}