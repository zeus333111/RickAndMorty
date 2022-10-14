package com.zeus.remoteapollo.repository

import com.nhaarman.mockitokotlin2.mock
import com.zeus.remoteapollo.api.graphQlClient
import com.zeus.remoteapollo.mappers.CharacterEntityMapper
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CharacterRemoteImplTest {

    private lateinit var characterRemoteImpl: CharacterRemoteImpl
    private val client: graphQlClient = mock()
    private val characterEntityMapper = CharacterEntityMapper()

    @Before
    fun setup() {
        characterRemoteImpl = CharacterRemoteImpl(client, characterEntityMapper)
    }

    @Test
    fun `get character list`() {
        assert(true)
    }
}
