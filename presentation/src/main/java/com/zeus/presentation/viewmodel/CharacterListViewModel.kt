package com.zeus.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.zeus.domain.interactor.GetCharacterListUseCase
import com.zeus.presentation.utils.CharacterUIModel
import com.zeus.presentation.utils.CoroutineContextProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(
    contextProvider: CoroutineContextProvider,
    private val characterListUseCase: GetCharacterListUseCase
) : BaseViewModel(contextProvider) {

    private val _characterList = MutableLiveData<CharacterUIModel>()
    val characterList: LiveData<CharacterUIModel> = _characterList

    override val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        val message = throwable.message
        _characterList.postValue(CharacterUIModel.Error(message ?: "Error"))
    }

    fun getCharacters() = launchCoroutineIO {
        characterListUseCase.invoke(Unit).collect {
            _characterList.postValue(CharacterUIModel.Success(it))
        }
    }
}
