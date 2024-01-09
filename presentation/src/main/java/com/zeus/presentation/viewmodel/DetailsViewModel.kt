package com.zeus.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.zeus.domain.interactor.GetCharacterUseCase
import com.zeus.presentation.utils.CoroutineContextProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    contextProvider: CoroutineContextProvider,
    private val getCharacterUseCase: GetCharacterUseCase,
) : BaseViewModel(contextProvider) {

    private val _state = MutableLiveData<DetailsState>()
    val state: LiveData<DetailsState> = _state

    override val coroutineExceptionHandler: CoroutineExceptionHandler =
        CoroutineExceptionHandler { _, throwable ->
            _state.postValue(
                DetailsState.Error(throwable.message),
            )
        }

    fun getCharacter(id: String) = launchCoroutineIO {
        _state.postValue(
            DetailsState.Loading,
        )
        getCharacterUseCase.invoke(id).collect { character ->
            character?.let {
                _state.postValue(
                    DetailsState.GetCharacterSuccess(it),
                )
            }
        }
    }
}
