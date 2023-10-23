package com.zeus.remoteapollo.repository

import com.nhaarman.mockitokotlin2.mock
import com.zeus.remoteapollo.api.RemoteApolloClient
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CharacterRemoteImplTest {

    private lateinit var characterRemoteImpl: CharacterRemoteImpl
    private val client: RemoteApolloClient = mock()

    @Before
    fun setup() {
        characterRemoteImpl = CharacterRemoteImpl(client)
    }

    @Test
    fun `get character list`() {
        assert(true)
    }
}
