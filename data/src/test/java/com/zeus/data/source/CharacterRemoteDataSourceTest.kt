package com.zeus.data.source

import com.zeus.data.repository.CharacterRemote
import com.zeus.data.utils.characterEntity
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.ArgumentMatchers.anyString
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import kotlin.test.assertFailsWith

class CharacterRemoteDataSourceTest {
    private val characterRemote: CharacterRemote = mock()

    private lateinit var characterRemoteDataSource: CharacterRemoteDataSource

    @Before
    fun setUp() {
        characterRemoteDataSource =
            CharacterRemoteDataSource(
                characterRemote,
            )
    }

    @Test
    fun `test getCharacters`() =
        runTest {
            whenever(characterRemote.getCharacters(anyInt())).thenReturn(listOf(characterEntity))

            val result = characterRemoteDataSource.getCharacters(1)

            assertEquals(listOf(characterEntity), result)
        }

    @Test
    fun `test saveCharacter`() =
        runTest {
            assertFailsWith<UnsupportedOperationException> {
                characterRemoteDataSource.saveCharacter(emptyList())
            }
        }

    @Test
    fun `test isCached`() =
        runTest {
            assertFailsWith<UnsupportedOperationException> {
                characterRemoteDataSource.isCached(1)
            }
        }

    @Test
    fun `test characterIsCached`() =
        runTest {
            assertFailsWith<UnsupportedOperationException> {
                characterRemoteDataSource.characterIsCached("0")
            }
        }

    @Test
    fun `test getCharacter`() =
        runTest {
            whenever(characterRemote.getCharacter(anyString())).thenReturn(characterEntity)

            val result = characterRemoteDataSource.getCharacter("0123")

            assertEquals(characterEntity, result)
        }
}
