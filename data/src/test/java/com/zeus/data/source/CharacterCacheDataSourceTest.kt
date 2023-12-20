package com.zeus.data.source

import com.zeus.data.repository.CharacterCache
import com.zeus.data.utils.characterEntity
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.ArgumentMatchers.anyList
import org.mockito.ArgumentMatchers.anyLong
import org.mockito.ArgumentMatchers.anyString
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class CharacterCacheDataSourceTest {
    private val characterCache: CharacterCache = mock()

    private lateinit var characterCacheDataSource: CharacterCacheDataSource

    @Before
    fun setup() {
        characterCacheDataSource = CharacterCacheDataSource(characterCache)
    }

    @Test
    fun `test getCharacters`() =
        runTest {
            val listOfCharacters = listOf(characterEntity)
            whenever(characterCache.getCharacters(anyInt())).thenReturn(listOfCharacters)
            val result = characterCacheDataSource.getCharacters(1)

            assertEquals(listOfCharacters, result)
        }

    @Test
    fun `test save character`() =
        runTest {
            characterCacheDataSource.saveCharacter(listOf(characterEntity))

            verify(characterCache).saveCharacters(anyList())
            verify(characterCache).setLastCacheTime(anyLong())
        }

    @Test
    fun `test isCached`() =
        runTest {
            whenever(characterCache.isCached(anyInt())).thenReturn(true)
            val isCached = characterCacheDataSource.isCached(1)

            assertTrue(isCached)
        }

    @Test
    fun `test characterIsCached`() =
        runTest {
            whenever(characterCache.characterIsCached(anyString())).thenReturn(true)
            val isCached = characterCacheDataSource.characterIsCached("test")

            assertTrue(isCached)
        }

    @Test
    fun `test getCharacter`() =
        runTest {
            whenever(characterCache.getCharacter(anyString())).thenReturn(characterEntity)
            val characterResult = characterCacheDataSource.getCharacter("test")

            assertEquals(characterEntity, characterResult)
        }
}
