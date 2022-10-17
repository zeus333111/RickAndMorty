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

    override suspend fun getCharacters(): Flow<List<Character>> = flow {
        val characterList = dataSourceFactory.getRemoteDataSource().getCharacters().map {
            characterMapper.mapFromEntity(it)
        }
        emit(characterList)
    }
}
