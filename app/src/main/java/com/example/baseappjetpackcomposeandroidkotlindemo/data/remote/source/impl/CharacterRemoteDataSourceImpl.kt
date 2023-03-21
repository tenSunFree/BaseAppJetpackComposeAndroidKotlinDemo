package com.example.baseappjetpackcomposeandroidkotlindemo.data.remote.source.impl

import com.example.baseappjetpackcomposeandroidkotlindemo.data.local.dao.FavoriteDao
import com.example.baseappjetpackcomposeandroidkotlindemo.data.model.CharacterInfoResponse
import com.example.baseappjetpackcomposeandroidkotlindemo.data.model.CharacterResponse
import com.example.baseappjetpackcomposeandroidkotlindemo.data.model.FavoriteEntity
import com.example.baseappjetpackcomposeandroidkotlindemo.data.remote.api.CharacterService
import com.example.baseappjetpackcomposeandroidkotlindemo.data.remote.source.CharacterRemoteDataSource
import com.example.baseappjetpackcomposeandroidkotlindemo.data.remote.utils.DataState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CharacterRemoteDataSourceImpl @Inject constructor(
    private val characterService: CharacterService,
    private val dao: FavoriteDao
) :
    BaseRemoteDataSource(), CharacterRemoteDataSource {

    override suspend fun getFavorite(favoriteId: Int): FavoriteEntity? = dao.getFavorite(favoriteId)

    override suspend fun getAllCharacters(
        page: Int,
        options: Map<String, String>
    ): CharacterResponse = characterService.getAllCharacters(page, options)

    override suspend fun getFilterCharacters(
        page: Int, options: Map<String, String>
    ): CharacterResponse = characterService.getFilterCharacter(page, options)

    override suspend fun getCharacter(characterId: Int): Flow<DataState<CharacterInfoResponse>> =
        getResult { characterService.getCharacter(characterId = characterId) }

    override suspend fun getCharacter(url: String): Flow<DataState<CharacterInfoResponse>> =
        getResult {
            characterService.getCharacter(url)
        }


    override suspend fun getFavoriteList(): List<FavoriteEntity> = dao.getFavoriteList()

    override suspend fun deleteFavoriteById(favoriteId: Int) = dao.deleteFavoriteById(favoriteId)

    override suspend fun deleteFavoriteList() = dao.deleteFavoriteList()

    override suspend fun saveFavorite(entity: FavoriteEntity) = dao.insert(entity)

    override suspend fun saveFavoriteList(entityList: List<FavoriteEntity>) = dao.insert(entityList)
}
