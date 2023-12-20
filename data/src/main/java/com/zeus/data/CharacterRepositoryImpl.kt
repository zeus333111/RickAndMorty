package com.zeus.data

import com.zeus.data.mapper.toCharacter
import com.zeus.data.mapper.toCharacterEntity
import com.zeus.data.source.CharacterDataSourceFactory
import com.zeus.domain.models.Character
import com.zeus.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val dataSourceFactory: CharacterDataSourceFactory,
) : CharacterRepository {
    override suspend fun getCharacters(page: Int): Flow<List<Character>> =
        flow {
            val isCached = dataSourceFactory.getCacheDataSource().isCached(page)
            val characterList =
                dataSourceFactory.getDataStore(isCached).getCharacters(page).map {
                    it.toCharacter()
                }
            saveCharacters(characterList, page)
            emit(characterList)
        }

    override suspend fun saveCharacters(
        list: List<Character>,
        page: Int,
    ) {
        val characters =
            list.map {
                it.toCharacterEntity().copy(page = page)
            }
        dataSourceFactory.getCacheDataSource().saveCharacter(characters)
    }

    override suspend fun getCharacter(id: String): Flow<Character?> =
        flow {
            val isCached = dataSourceFactory.getCacheDataSource().characterIsCached(id)
            val character = dataSourceFactory.getDataStore(isCached).getCharacter(id)
            emit(character?.toCharacter())
        }
}
