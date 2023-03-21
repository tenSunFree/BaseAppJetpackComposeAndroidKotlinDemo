package com.example.baseappjetpackcomposeandroidkotlindemo.data.di

import android.content.Context
import androidx.compose.runtime.Stable
import com.example.baseappjetpackcomposeandroidkotlindemo.data.local.dao.FavoriteDao
import com.example.baseappjetpackcomposeandroidkotlindemo.data.local.db.RickAndMortyDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Stable
@Module
@InstallIn(SingletonComponent::class)
class LocalModule {

    @Provides
    @Singleton
    fun provideRickAndMortyDatabase(
        @ApplicationContext context: Context
    ): RickAndMortyDatabase {
        return RickAndMortyDatabase.getDatabase(context)
    }

    @Provides
    @Singleton
    fun provideFavoriteDao(appDatabase: RickAndMortyDatabase): FavoriteDao {
        return appDatabase.favoriteDao()
    }
}