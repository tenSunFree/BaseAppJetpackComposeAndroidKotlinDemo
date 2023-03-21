package com.example.baseappjetpackcomposeandroidkotlindemo.data.remote.api

import com.example.baseappjetpackcomposeandroidkotlindemo.data.model.CharacterInfoResponse
import com.example.baseappjetpackcomposeandroidkotlindemo.data.model.CharacterResponse
import com.example.baseappjetpackcomposeandroidkotlindemo.data.remote.utils.Constants
import retrofit2.Response
import retrofit2.http.*

interface CharacterService {

    @GET(Constants.CHARACTER_LIST)
    suspend fun getAllCharacters(
        @Query(Constants.PARAM_PAGE) page: Int,
        @QueryMap options: Map<String, String>? = null
    ): CharacterResponse

    @GET(Constants.GET_CHARACTER)
    suspend fun getCharacter(
        @Path(Constants.PARAM_ID) characterId: Int
    ): Response<CharacterInfoResponse>

    @GET(Constants.GET_CHARACTER)
    suspend fun getCharacter(
        @Url url: String
    ): Response<CharacterInfoResponse>

    @GET(Constants.CHARACTER_FILTER)
    suspend fun getFilterCharacter(
        @Query(Constants.PARAM_PAGE) page: Int,
        @QueryMap options: Map<String, String>? = null
    ): CharacterResponse
}