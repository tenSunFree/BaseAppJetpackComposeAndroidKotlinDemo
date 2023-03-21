package com.example.baseappjetpackcomposeandroidkotlindemo.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.baseappjetpackcomposeandroidkotlindemo.data.local.base.BaseDao
import com.example.baseappjetpackcomposeandroidkotlindemo.data.model.FavoriteEntity
import com.example.baseappjetpackcomposeandroidkotlindemo.data.remote.utils.Constants

@Dao
interface FavoriteDao : BaseDao<FavoriteEntity> {
    @Query("SELECT * FROM ${Constants.TABLE_NAME}")
    suspend fun getFavoriteList(): List<FavoriteEntity>

    @Query("SELECT * FROM ${Constants.TABLE_NAME} WHERE id = :favoriteId")
    suspend fun getFavorite(favoriteId: Int): FavoriteEntity?

    @Query("DELETE FROM ${Constants.TABLE_NAME}")
    suspend fun deleteFavoriteList()

    @Query("DELETE FROM ${Constants.TABLE_NAME} WHERE id = :favoriteId")
    suspend fun deleteFavoriteById(favoriteId: Int)
}