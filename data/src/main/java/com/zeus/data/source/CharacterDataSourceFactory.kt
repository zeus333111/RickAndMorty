package com.zeus.data.source

import com.zeus.data.repository.CharacterCache
import com.zeus.data.repository.CharacterDataSource
import javax.inject.Inject

open class CharacterDataSourceFactory @Inject constructor(
    private val remoteDataSource: CharacterRemoteDataSource,
    private val characterCacheDataSource: CharacterCacheDataSource,
    private val characterCache: CharacterCache,
) {
    suspend fun getDataStore(isCache: Boolean): CharacterDataSource {
        return if (isCache && !characterCache.isExpired()) {
            return getCacheDataSource()
        } else {
            getRemoteDataSource()
        }
    }

    private fun getRemoteDataSource(): CharacterDataSource {
        return remoteDataSource
    }

    fun getCacheDataSource(): CharacterCacheDataSource {
        return characterCacheDataSource
    }
}
