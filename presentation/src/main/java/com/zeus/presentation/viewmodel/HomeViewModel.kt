package com.zeus.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.zeus.domain.interactor.GetCharacterListUseCase
import com.zeus.presentation.utils.CharacterUIModel
import com.zeus.presentation.utils.CoroutineContextProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    contextProvider: CoroutineContextProvider,
    private val characterListUseCase: GetCharacterListUseCase
) : BaseViewModel(contextProvider) {

    var state by mutableStateOf(HomeState(isLoading = true))
        private set

    private val _eventFlow = MutableSharedFlow<CharacterUIModel>()
    val eventFlow: SharedFlow<CharacterUIModel> = _eventFlow

    private var currentPage = 1

    override val coroutineExceptionHandler = CoroutineExceptionHandler { context, throwable ->
        val message = throwable.message
        // _characterList.postValue(CharacterUIModel.Error(message ?: "Error"))
        viewModelScope.launch {
            _eventFlow.emit(CharacterUIModel.Error(message ?: "Error"))
        }
    }

    /*private val _characterList = MutableLiveData<CharacterUIModel>()
    val characterList: LiveData<CharacterUIModel> = _characterList*/

    fun getCharacters(increase: Boolean) = launchCoroutineIO {
        state = state.copy(isLoading = true)
        if (increase) {
            currentPage++
        } else if (currentPage > 1) {
            currentPage--
        }
        val showPrevious = currentPage > 1
        val showNext = currentPage < 42

        characterListUseCase.invoke(currentPage).collect {
            // _characterList.postValue(CharacterUIModel.Success(it))
            state = state.copy(
                characters = it,
                isLoading = false,
                showNext = showNext,
                showPrevious = showPrevious
            )
        }
    }
}
