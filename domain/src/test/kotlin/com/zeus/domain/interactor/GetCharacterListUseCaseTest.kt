package com.zeus.domain.interactor

import app.cash.turbine.test
import com.zeus.domain.repository.CharacterRepository
import com.zeus.domain.utils.characterDomain
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class GetCharacterListUseCaseTest {

    private val characterRepository: CharacterRepository = mock()

    private lateinit var getCharacterListUseCase: GetCharacterListUseCase

    @Before
    fun setup() {
        getCharacterListUseCase = GetCharacterListUseCase(
            characterRepository,
        )
    }

    @Test
    fun `test get character use case`() = runTest {
        whenever(characterRepository.getCharacters(anyInt())).thenReturn(flowOf(listOf(characterDomain)))

        getCharacterListUseCase.invoke(1).test {
            assertEquals(listOf(characterDomain), awaitItem())
            awaitComplete()
        }
    }
}
