package com.zeus.data.source

import com.zeus.data.models.CharacterEntity
import com.zeus.data.repository.CharacterDataSource
import com.zeus.data.repository.CharacterRemote
import javax.inject.Inject

class CharacterRemoteDataSource @Inject constructor(
    private val characterRemote: CharacterRemote,
) : CharacterDataSource {
    override suspend fun getCharacters(page: Int): List<CharacterEntity> {
        return characterRemote.getCharacters(page)
    }

    override suspend fun saveCharacter(list: List<CharacterEntity>) {
        throw UnsupportedOperationException("Save Character is not supported for RemoteDataSource")
    }

    override suspend fun isCached(page: Int): Boolean {
        throw UnsupportedOperationException("isCached is not supported for RemoteDataSource")
    }

    override suspend fun characterIsCached(id: String): Boolean {
        throw UnsupportedOperationException("characterIsCached is not supported for RemoteDataSource")
    }

    override suspend fun getCharacter(id: String): CharacterEntity? {
        return characterRemote.getCharacter(id)
    }
}
