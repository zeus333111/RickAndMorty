package com.zeus.data.source

import com.zeus.data.repository.CharacterDataSource
import javax.inject.Inject

class CharacterDataSourceFactory @Inject constructor(
    // todo cache
    private val remoteDataSource: CharacterRemoteDataSource
) {

    // todo funcion de cache o remoto

    fun getRemoteDataSource(): CharacterDataSource {
        return remoteDataSource
    }
}
