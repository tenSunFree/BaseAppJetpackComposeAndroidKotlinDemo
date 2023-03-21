package com.example.baseappjetpackcomposeandroidkotlindemo.domain.di

import com.example.baseappjetpackcomposeandroidkotlindemo.domain.repository.CharacterRepository
import com.example.baseappjetpackcomposeandroidkotlindemo.domain.usecase.characters.GetCharactersUseCase
import com.example.baseappjetpackcomposeandroidkotlindemo.domain.usecase.favorite.UpdateFavoriteUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModule {

    @ViewModelScoped
    @Provides
    fun provideGetCharactersUseCase(
        characterRepository: CharacterRepository
    ) = GetCharactersUseCase(characterRepository)

    @ViewModelScoped
    @Provides
    fun provideUpdateFavoriteUseCase(
        characterRepository: CharacterRepository
    ) = UpdateFavoriteUseCase(characterRepository)
}