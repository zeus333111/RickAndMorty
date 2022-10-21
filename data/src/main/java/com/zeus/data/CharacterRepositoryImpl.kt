package com.zeus.data

import com.zeus.data.mapper.CharacterMapper
import com.zeus.data.source.CharacterDataSourceFactory
import com.zeus.domain.models.Character
import com.zeus.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val dataSourceFactory: CharacterDataSourceFactory,
    private val characterMapper: CharacterMapper
) : CharacterRepository {

    override suspend fun getCharacters(page: Int): Flow<List<Character>> = flow {
        val isCached = dataSourceFactory.getCacheDataSource().isCached(page)
        val characterList = dataSourceFactory.getDataStore(isCached).getCharacters(page).map {
            characterMapper.mapFromEntity(it)
        }
        saveCharacters(characterList, page)
        emit(characterList)
    }

    override suspend fun saveCharacters(list: List<Character>, page: Int) {
        val characters = list.map {
            characterMapper.mapToEntity(it).copy(page = page)
        }
        dataSourceFactory.getCacheDataSource().saveCharacter(characters)
    }
}
