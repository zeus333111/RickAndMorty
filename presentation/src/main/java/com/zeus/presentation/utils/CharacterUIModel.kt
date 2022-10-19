package com.zeus.presentation.utils

sealed class CharacterUIModel {
    data class Error(var error: String = "") : CharacterUIModel()
}
