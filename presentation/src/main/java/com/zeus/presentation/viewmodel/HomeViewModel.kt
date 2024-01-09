package com.zeus.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.zeus.domain.interactor.GetCharacterListUseCase
import com.zeus.presentation.utils.CoroutineContextProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    contextProvider: CoroutineContextProvider,
    private val characterListUseCase: GetCharacterListUseCase,
) : BaseViewModel(contextProvider) {

    private val _state = MutableLiveData(HomeState())
    val state: LiveData<HomeState> = _state

    private var currentPage = 1

    override val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        val message = throwable.message
        _state.postValue(
            state.value?.copy(
                isLoading = false,
                showError = true,
                errorString = message ?: "Error",
            ),
        )
    }

    fun getCharacters(increase: Boolean) = launchCoroutineIO {
        _state.postValue(
            state.value?.copy(isLoading = true),
        )

        if (increase) {
            currentPage++
        } else if (currentPage > 1) {
            currentPage--
        }
        val showPrevious = currentPage > 1
        val showNext = currentPage < 42
        characterListUseCase.invoke(currentPage).collect {
            _state.postValue(
                state.value?.copy(
                    characters = it,
                    isLoading = false,
                    showNext = showNext,
                    showPrevious = showPrevious,
                ),
            )
        }
    }

    fun dismissError() = launchCoroutineIO {
        _state.postValue(
            state.value?.copy(showError = false),
        )
    }
}
