package com.zeus.data.repository

import com.zeus.data.models.CharacterEntity

interface CharacterCache {
    suspend fun getCharacters(page: Int): List<CharacterEntity>
    suspend fun saveCharacters(listCharacters: List<CharacterEntity>)
    suspend fun isCached(page: Int): Boolean
    suspend fun setLastCacheTime(lastCache: Long)
    suspend fun isExpired(): Boolean
}
