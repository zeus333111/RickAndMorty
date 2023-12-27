package com.zeus.domain.interactor

import app.cash.turbine.test
import com.zeus.domain.repository.CharacterRepository
import com.zeus.domain.utils.characterDomain
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class GetCharacterUseCaseTest {

    private val characterRepository: CharacterRepository = mock()

    private lateinit var getCharacterUseCase: GetCharacterUseCase

    @Before
    fun setup() {
        getCharacterUseCase = GetCharacterUseCase(
            characterRepository,
        )
    }

    @Test
    fun `test get character use case`() = runTest {
        whenever(characterRepository.getCharacter(anyString())).thenReturn(flowOf(characterDomain))

        getCharacterUseCase.invoke("test").test {
            assertEquals(characterDomain, awaitItem())
            awaitComplete()
        }
    }
}
