package com.zeus.cache

import com.zeus.cache.dao.CharacterDao
import com.zeus.cache.mapper.CharacterCacheMapper
import com.zeus.cache.utils.CachePreferencesHelper
import com.zeus.data.models.CharacterEntity
import com.zeus.data.repository.CharacterCache
import javax.inject.Inject

class CharacterCacheImpl @Inject constructor(
    private val characterDao: CharacterDao,
    private val characterCacheMapper: CharacterCacheMapper,
    private val preferencesHelper: CachePreferencesHelper
) : CharacterCache {

    override suspend fun getCharacters(page: Int): List<CharacterEntity> {
        return characterDao.getCharacters(page).map {
            characterCacheMapper.mapFromCache(it)
        }
    }

    override suspend fun saveCharacters(listCharacters: List<CharacterEntity>) {
        val list = listCharacters.map { characterCacheMapper.mapToCache(it) }
        characterDao.saveCharacters(list)
    }

    override suspend fun isCached(page: Int): Boolean {
        return characterDao.getCharacters(page).isNotEmpty()
    }

    override suspend fun setLastCacheTime(lastCache: Long) {
        preferencesHelper.lastCache = lastCache
    }

    override suspend fun isExpired(): Boolean {
        val currentTime = System.currentTimeMillis()
        val lastUpdateTime = getLastCacheUpdateTimeMillis()
        return currentTime - lastUpdateTime > EXPIRATION_TIME
    }

    private fun getLastCacheUpdateTimeMillis(): Long {
        return preferencesHelper.lastCache
    }

    companion object {
        const val EXPIRATION_TIME = (5 * 60 * 1000).toLong()
    }
}
