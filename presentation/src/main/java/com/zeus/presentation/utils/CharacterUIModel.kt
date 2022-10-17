package com.zeus.presentation.utils

import com.zeus.domain.models.Character

sealed class CharacterUIModel {
    object Loading : CharacterUIModel()
    data class Error(var error: String = "") : CharacterUIModel()
    data class Success(val data: List<Character>) : CharacterUIModel()
}
