package com.example.baseappjetpackcomposeandroidkotlindemo.data.repository

import com.example.baseappjetpackcomposeandroidkotlindemo.data.local.dao.FavoriteDao
import com.example.baseappjetpackcomposeandroidkotlindemo.data.model.CharacterResponse
import com.example.baseappjetpackcomposeandroidkotlindemo.data.model.FavoriteEntity
import com.example.baseappjetpackcomposeandroidkotlindemo.data.remote.source.CharacterRemoteDataSource
import com.example.baseappjetpackcomposeandroidkotlindemo.domain.repository.CharacterRepository
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val characterRemoteDataSource: CharacterRemoteDataSource,
    private val dao: FavoriteDao
) : CharacterRepository {

    override suspend fun getAllCharacters(
        page: Int,
        options: Map<String, String>
    ): CharacterResponse =
        characterRemoteDataSource.getAllCharacters(page = page, options = options)

    override suspend fun getFavorite(favoriteId: Int): FavoriteEntity? = dao.getFavorite(favoriteId)

    override suspend fun deleteFavoriteById(favoriteId: Int) = dao.deleteFavoriteById(favoriteId)

    override suspend fun saveFavorite(entity: FavoriteEntity) = dao.insert(entity)
}