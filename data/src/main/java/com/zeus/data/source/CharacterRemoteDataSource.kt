package com.zeus.data.source

import com.zeus.data.models.CharacterEntity
import com.zeus.data.repository.CharacterDataSource
import com.zeus.data.repository.CharacterRemote
import javax.inject.Inject

class CharacterRemoteDataSource @Inject constructor(
    private val characterRemote: CharacterRemote
) : CharacterDataSource {
    override suspend fun getCharacters(): List<CharacterEntity> {
        return characterRemote.getCharacters(0)
    }
}
