package com.zeus.data.source

import com.zeus.data.models.CharacterEntity
import com.zeus.data.repository.CharacterCache
import com.zeus.data.repository.CharacterDataSource
import javax.inject.Inject

class CharacterCacheDataSource @Inject constructor(
    private val characterCache: CharacterCache,
) : CharacterDataSource {
    override suspend fun getCharacters(page: Int): List<CharacterEntity> {
        return characterCache.getCharacters(page)
    }

    override suspend fun saveCharacter(list: List<CharacterEntity>) {
        characterCache.saveCharacters(list)
        characterCache.setLastCacheTime(System.currentTimeMillis())
    }

    override suspend fun isCached(page: Int): Boolean {
        return characterCache.isCached(page)
    }

    override suspend fun characterIsCached(id: String): Boolean {
        return characterCache.characterIsCached(id)
    }

    override suspend fun getCharacter(id: String): CharacterEntity? {
        return characterCache.getCharacter(id)
    }
}
