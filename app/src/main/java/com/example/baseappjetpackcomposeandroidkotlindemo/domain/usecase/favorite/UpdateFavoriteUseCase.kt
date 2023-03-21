package com.example.baseappjetpackcomposeandroidkotlindemo.domain.usecase.favorite

import com.example.baseappjetpackcomposeandroidkotlindemo.data.model.dto.CharacterDto
import com.example.baseappjetpackcomposeandroidkotlindemo.data.model.dto.extension.toFavoriteEntity
import com.example.baseappjetpackcomposeandroidkotlindemo.domain.base.BaseUseCase
import com.example.baseappjetpackcomposeandroidkotlindemo.domain.base.IParams
import com.example.baseappjetpackcomposeandroidkotlindemo.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.flow

class UpdateFavoriteUseCase(
    internal val repository: CharacterRepository
) : BaseUseCase<UpdateFavoriteUseCase.Params, Unit> {

    data class Params(
        val character: CharacterDto
    ) : IParams

    override suspend fun invoke(param: Params) = flow<Unit> {
        val dto = param.character
        val character = repository.getFavorite(dto.id ?: 0)
        if (character == null) {
            repository.saveFavorite(dto.toFavoriteEntity())
        } else {
            repository.deleteFavoriteById(dto.id ?: 0)
        }
        emit(Unit)
    }
}