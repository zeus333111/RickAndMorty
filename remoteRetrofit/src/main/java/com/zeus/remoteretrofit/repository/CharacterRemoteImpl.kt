package com.zeus.remoteretrofit.repository

import com.zeus.data.models.CharacterEntity
import com.zeus.data.repository.CharacterRemote
import com.zeus.remoteretrofit.api.RetrofitServices
import com.zeus.remoteretrofit.mappers.toCharacterEntity
import javax.inject.Inject

class CharacterRemoteImpl @Inject constructor(
    private val client: RetrofitServices,
) : CharacterRemote {

    override suspend fun getCharacters(page: Int): List<CharacterEntity> {
        return client.getCharacters(page).results.map { it.toCharacterEntity() }
    }

    override suspend fun getCharacter(id: String): CharacterEntity {
        return client.getCharacter(id.toInt()).toCharacterEntity()
    }
}
