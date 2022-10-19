package com.zeus.remoteapollo.repository

import com.apollographql.apollo3.api.Optional
import com.zeus.apollo.GetCharactersQuery
import com.zeus.data.models.CharacterEntity
import com.zeus.data.repository.CharacterRemote
import com.zeus.remoteapollo.api.RemoteApolloClient
import com.zeus.remoteapollo.mappers.CharacterEntityMapper
import javax.inject.Inject

class CharacterRemoteImpl @Inject constructor(
    private val client: RemoteApolloClient,
    private val characterEntityMapper: CharacterEntityMapper
) : CharacterRemote {

    override suspend fun getCharacters(page: Int): List<CharacterEntity> {
        val dataFromServer = client.getClient().query(GetCharactersQuery(Optional.present(page))).execute().data
        return dataFromServer?.characters?.results?.map {
            characterEntityMapper.mapFromModel(it)
        } ?: emptyList()
    }
}
