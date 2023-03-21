package com.example.baseappjetpackcomposeandroidkotlindemo.domain.usecase.characters

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.baseappjetpackcomposeandroidkotlindemo.data.model.dto.CharacterDto
import com.example.baseappjetpackcomposeandroidkotlindemo.data.model.dto.extension.toCharacterDtoList
import com.example.baseappjetpackcomposeandroidkotlindemo.domain.repository.CharacterRepository
import java.io.IOException

class CharacterPagingSource(
    internal val repository: CharacterRepository,
    private val options: Map<String, String>
) : PagingSource<Int, CharacterDto>() {

    override fun getRefreshKey(state: PagingState<Int, CharacterDto>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterDto> {
        val page = params.key ?: 1
        return try {
            val response = repository.getAllCharacters(page, options)
            val characterList = response.results.orEmpty().toCharacterDtoList()
            characterList.map {
                val characterFav = repository.getFavorite(it.id ?: 0)
                it.isFavorite = characterFav != null
            }
            LoadResult.Page(
                data = characterList,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (characterList.isEmpty()) null else page + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        }
    }
}