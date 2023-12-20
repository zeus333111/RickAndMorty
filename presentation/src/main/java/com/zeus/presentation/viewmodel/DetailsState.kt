package com.zeus.presentation.viewmodel

import com.zeus.domain.models.Character

data class DetailsState(
    val isLoading: Boolean = false,
    val character: Character? = null,
    val showError: Boolean = false,
    val errorMessage: String? = null,
)
