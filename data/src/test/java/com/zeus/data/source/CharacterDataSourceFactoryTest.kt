package com.zeus.data.source

import com.zeus.data.repository.CharacterCache
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.whenever

class CharacterDataSourceFactoryTest {
    private val characterRemoteData: CharacterRemoteDataSource = mock()
    private val characterCacheDataSource: CharacterCacheDataSource = mock()
    private val characterCache: CharacterCache = mock()

    private lateinit var characterDataSourceFactory: CharacterDataSourceFactory

    @Before
    fun setUp() {
        characterDataSourceFactory =
            CharacterDataSourceFactory(
                characterRemoteData,
                characterCacheDataSource,
                characterCache,
            )
    }

    @Test
    fun `test getData store isCached true and character cache is expire true`() =
        runTest {
            whenever(characterCache.isExpired()).thenReturn(true)

            val source = characterDataSourceFactory.getDataStore(true)

            assertEquals(characterRemoteData, source)
        }

    @Test
    fun `test getData store isCached true and character cache is expire false`() =
        runTest {
            whenever(characterCache.isExpired()).thenReturn(false)

            val source = characterDataSourceFactory.getDataStore(true)

            assertEquals(characterCacheDataSource, source)
        }

    @Test
    fun `test getData store isCached false and character cache is expire true`() =
        runTest {
            whenever(characterCache.isExpired()).thenReturn(true)

            val source = characterDataSourceFactory.getDataStore(false)

            assertEquals(characterRemoteData, source)
        }

    @Test
    fun `test getData store isCached false and character cache is expire false`() =
        runTest {
            whenever(characterCache.isExpired()).thenReturn(false)

            val source = characterDataSourceFactory.getDataStore(false)

            assertEquals(characterRemoteData, source)
        }
}
