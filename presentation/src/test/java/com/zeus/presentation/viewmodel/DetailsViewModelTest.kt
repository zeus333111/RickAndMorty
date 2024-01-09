package com.zeus.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.zeus.domain.interactor.GetCharacterUseCase
import com.zeus.presentation.utils.CoroutineContextProvider
import com.zeus.presentation.utils.MainCoroutineRule
import com.zeus.presentation.utils.characterDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.anyString
import org.mockito.Mockito.mock
import org.mockito.kotlin.argumentCaptor
import org.mockito.kotlin.atMost
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class DetailsViewModelTest {

    private val coroutineContextProvider: CoroutineContextProvider = mock()
    private val getCharacterUseCase: GetCharacterUseCase = mock()
    private val observer: Observer<DetailsState> = mock()

    private var detailsViewModel: DetailsViewModel? = null

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @Before
    fun setUp() {
        detailsViewModel = DetailsViewModel(
            coroutineContextProvider,
            getCharacterUseCase,
        )
        whenever(coroutineContextProvider.io).thenReturn(Dispatchers.IO)
    }

    @After
    fun teardown() {
        detailsViewModel = null
    }

    @Test
    fun `test get character success`() = runTest {
        whenever(getCharacterUseCase.invoke(anyString())).thenReturn(flowOf(characterDomain))

        detailsViewModel?.state?.observeForever(observer)

        detailsViewModel?.getCharacter("1")?.join()

        argumentCaptor<DetailsState> {
            verify(observer, times(2)).onChanged(capture())

            assertTrue(message = "isLoading", actual = allValues[0] is DetailsState.Loading)
            assertEquals(message = "character", actual = (allValues[1] as DetailsState.GetCharacterSuccess).character, expected = characterDomain)
        }

        detailsViewModel?.state?.removeObserver(observer)
    }

    @Test
    fun `test get character when throw an error`() = runTest {
        whenever(getCharacterUseCase.invoke(anyString())).then { throw Exception("Test Exception") }

        detailsViewModel?.state?.observeForever(observer)

        detailsViewModel?.getCharacter("2")?.join()

        argumentCaptor<DetailsState> {
            verify(observer, atMost(2)).onChanged(capture())

            assertTrue(message = "isLoading", actual = allValues[0] is DetailsState.Loading)
            assertTrue(message = "error", actual = allValues[1] is DetailsState.Error)
        }

        detailsViewModel?.state?.removeObserver(observer)
    }
}
