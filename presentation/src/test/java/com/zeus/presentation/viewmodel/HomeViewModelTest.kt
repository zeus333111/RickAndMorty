package com.zeus.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.zeus.domain.interactor.GetCharacterListUseCase
import com.zeus.presentation.utils.CoroutineContextProvider
import com.zeus.presentation.utils.MainCoroutineRule
import com.zeus.presentation.utils.characterDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.anyInt
import org.mockito.Mockito.mock
import org.mockito.kotlin.argumentCaptor
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import kotlin.test.assertEquals

class HomeViewModelTest {

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private val contextProvider: CoroutineContextProvider = mock()
    private val characterListUseCase: GetCharacterListUseCase = mock()
    private val observer: Observer<HomeState> = mock()

    private lateinit var viewModel: HomeViewModel

    @Before
    fun setup() {
        viewModel = HomeViewModel(
            contextProvider,
            characterListUseCase,
        )
        whenever(contextProvider.io).thenReturn(Dispatchers.IO)
    }

    @Test
    fun `test getCharacters success`() = runTest {
        whenever(characterListUseCase.invoke(anyInt())).thenReturn(flowOf(listOf(characterDomain)))

        viewModel.state.observeForever(observer)

        viewModel.getCharacters(true).join()

        argumentCaptor<HomeState> {
            verify(observer, times(3)).onChanged(capture())

            assertEquals(message = "isLoading", actual = allValues[1].isLoading, expected = true)

            assertEquals(message = "character", actual = allValues[2].characters, expected = listOf(characterDomain))
            assertEquals(message = "isLoading", actual = allValues[2].isLoading, expected = false)
            assertEquals(message = "showNext", actual = allValues[2].showNext, expected = true)
            assertEquals(message = "showPrevious", actual = allValues[2].showPrevious, expected = true)
        }

        viewModel.state.removeObserver(observer)
    }

    @Test
    fun `test getCharacters error`() = runTest {
        whenever(characterListUseCase.invoke(anyInt())).thenAnswer { throw Exception("Test Exception") }

        viewModel.state.observeForever(observer)

        viewModel.getCharacters(true).join()

        argumentCaptor<HomeState> {
            verify(observer, times(3)).onChanged(capture())

            assertEquals(message = "isLoading", actual = allValues[1].isLoading, expected = true)

            assertEquals(message = "isLoading", actual = allValues[2].isLoading, expected = false)
            assertEquals(message = "showError", actual = allValues[2].showError, expected = true)
            assertEquals(message = "errorMessage", actual = allValues[2].errorString, expected = "Test Exception")
        }
    }

    @Test
    fun `test showError true`() = runTest {
        viewModel.state.observeForever(observer)

        viewModel.dismissError().join()

        argumentCaptor<HomeState> {
            verify(observer, times(2)).onChanged(capture())

            assertEquals(message = "showError", actual = allValues[1].showError, expected = false)
        }

        viewModel.state.removeObserver(observer)
    }
}
