package com.zeus.data

import app.cash.turbine.test
import com.zeus.data.repository.CharacterDataSource
import com.zeus.data.source.CharacterCacheDataSource
import com.zeus.data.source.CharacterDataSourceFactory
import com.zeus.data.utils.characterDomain
import com.zeus.data.utils.characterEntity
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyBoolean
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.ArgumentMatchers.anyList
import org.mockito.ArgumentMatchers.anyString
import org.mockito.kotlin.mock
import org.mockito.kotlin.spy
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import kotlin.test.assertEquals

class CharacterRepositoryImplTest {
    private val characterDataSourceFactory: CharacterDataSourceFactory = mock()
    private val characterCacheDataSource: CharacterCacheDataSource = mock()
    private val characterDataSource: CharacterDataSource = mock()

    private lateinit var characterRepositoryImpl: CharacterRepositoryImpl

    @Before
    fun setUp() {
        characterRepositoryImpl =
            CharacterRepositoryImpl(
                characterDataSourceFactory,
            )
    }

    @Test
    fun `test get characters`() =
        runTest {
            val spyImpl = spy(characterRepositoryImpl)
            whenever(characterDataSourceFactory.getCacheDataSource()).thenReturn(characterCacheDataSource)
            whenever(characterCacheDataSource.isCached(anyInt())).thenReturn(false)
            whenever(characterDataSourceFactory.getDataStore(anyBoolean())).thenReturn(characterDataSource)
            whenever(characterDataSource.getCharacters(anyInt())).thenReturn(
                listOf(
                    characterEntity,
                ),
            )

            spyImpl.getCharacters(1).test {
                assertEquals(listOf(characterDomain), awaitItem())
                awaitComplete()
            }

            verify(spyImpl).saveCharacters(anyList(), anyInt())
        }

    @Test
    fun `test save characters`() =
        runTest {
            whenever(characterDataSourceFactory.getCacheDataSource()).thenReturn(characterCacheDataSource)

            characterRepositoryImpl.saveCharacters(listOf(characterDomain), 1)

            verify(characterCacheDataSource).saveCharacter(anyList())
        }

    @Test
    fun `test get character`() =
        runTest {
            whenever(characterDataSourceFactory.getCacheDataSource()).thenReturn(characterCacheDataSource)
            whenever(characterCacheDataSource.characterIsCached(anyString())).thenReturn(true)
            whenever(characterDataSourceFactory.getDataStore(anyBoolean())).thenReturn(characterCacheDataSource)
            whenever(characterCacheDataSource.getCharacter(anyString())).thenReturn(characterEntity)

            characterRepositoryImpl.getCharacter("1").test {
                assertEquals(characterDomain, awaitItem())
                awaitComplete()
            }
        }
}
