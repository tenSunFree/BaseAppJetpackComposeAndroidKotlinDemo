package com.example.baseappjetpackcomposeandroidkotlindemo.data.di

import androidx.compose.runtime.Stable
import com.example.baseappjetpackcomposeandroidkotlindemo.data.local.dao.FavoriteDao
import com.example.baseappjetpackcomposeandroidkotlindemo.data.remote.api.CharacterService
import com.example.baseappjetpackcomposeandroidkotlindemo.data.remote.source.CharacterRemoteDataSource
import com.example.baseappjetpackcomposeandroidkotlindemo.data.remote.source.impl.CharacterRemoteDataSourceImpl
import com.example.baseappjetpackcomposeandroidkotlindemo.data.repository.CharacterRepositoryImpl
import com.example.baseappjetpackcomposeandroidkotlindemo.domain.repository.CharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@Stable
@Module
@InstallIn(ViewModelComponent::class)
class CharacterModule {
    @Provides
    fun provideCharacterService(retrofit: Retrofit): CharacterService =
        retrofit.create(CharacterService::class.java)

    @Provides
    fun provideCharacterRemoteDataSource(
        characterService: CharacterService,
        dao: FavoriteDao
    ): CharacterRemoteDataSource =
        CharacterRemoteDataSourceImpl(characterService, dao)

    @Provides
    fun provideCharacterRepository(
        accountRemoteDataSource: CharacterRemoteDataSource,
        dao: FavoriteDao
    ): CharacterRepository =
        CharacterRepositoryImpl(accountRemoteDataSource, dao)
}