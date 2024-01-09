package com.zeus.presentation.viewmodel

import com.zeus.domain.models.Character

sealed class DetailsState {
    data object Idle : DetailsState()
    data object Loading : DetailsState()
    class GetCharacterSuccess(val character: Character) : DetailsState()
    class Error(val errorMessage: String?) : DetailsState()
}
