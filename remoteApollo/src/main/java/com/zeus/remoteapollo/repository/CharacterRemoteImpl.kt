package com.zeus.remoteapollo.repository

import com.apollographql.apollo3.api.Optional
import com.zeus.apollo.GetCharacterQuery
import com.zeus.apollo.GetCharactersQuery
import com.zeus.data.models.CharacterEntity
import com.zeus.data.repository.CharacterRemote
import com.zeus.remoteapollo.api.RemoteApolloClient
import com.zeus.remoteapollo.mappers.toCharacterEntity
import com.zeus.remoteapollo.mappers.toCharacterEntityList
import javax.inject.Inject

class CharacterRemoteImpl @Inject constructor(
    private val client: RemoteApolloClient
) : CharacterRemote {

    override suspend fun getCharacters(page: Int): List<CharacterEntity> {
        val dataFromServer = client.getClient().query(
            GetCharactersQuery(Optional.present(page))
        ).execute().data
        return dataFromServer.toCharacterEntityList()
    }

    override suspend fun getCharacter(id: String): CharacterEntity? {
        val dataFromServer = client.getClient().query(
            GetCharacterQuery(id)
        ).execute().data
        return dataFromServer?.character?.characterData?.toCharacterEntity()
    }
}
