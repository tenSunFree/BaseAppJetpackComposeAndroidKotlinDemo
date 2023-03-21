package com.example.baseappjetpackcomposeandroidkotlindemo.data.di

import android.content.Context
import androidx.compose.runtime.Stable
import com.example.baseappjetpackcomposeandroidkotlindemo.RickAndMortyApp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Stable
@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): RickAndMortyApp {
        return app as RickAndMortyApp
    }
}