package com.zeus.cache

import com.zeus.cache.dao.CharacterDao
import com.zeus.cache.mapper.toCharacterCacheEntity
import com.zeus.cache.mapper.toCharacterEntity
import com.zeus.cache.utils.CachePreferencesHelper
import com.zeus.data.models.CharacterEntity
import com.zeus.data.repository.CharacterCache
import javax.inject.Inject

class CharacterCacheImpl @Inject constructor(
    private val characterDao: CharacterDao,
    private val preferencesHelper: CachePreferencesHelper,
) : CharacterCache {

    override suspend fun getCharacters(page: Int): List<CharacterEntity> {
        return characterDao.getCharacters(page).map {
            it.toCharacterEntity()
        }
    }

    override suspend fun saveCharacters(listCharacters: List<CharacterEntity>) {
        val list = listCharacters.map { it.toCharacterCacheEntity() }
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

    override suspend fun characterIsCached(id: String): Boolean {
        return characterDao.getCharacter(id) != null
    }

    override suspend fun getCharacter(id: String): CharacterEntity? {
        return characterDao.getCharacter(id)?.toCharacterEntity()
    }

    companion object {
        const val EXPIRATION_TIME = (5 * 60 * 1000).toLong()
    }
}
