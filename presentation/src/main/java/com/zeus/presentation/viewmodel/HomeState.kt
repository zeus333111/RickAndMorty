package com.zeus.presentation.viewmodel

import com.zeus.domain.models.Character

data class HomeState(
    val characters: List<Character> = emptyList(),
    val showPrevious: Boolean = false,
    val showNext: Boolean = false,
    val isLoading: Boolean = false,
    val showError: Boolean = false,
    val errorString: String = ""
)
