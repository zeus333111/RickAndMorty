package com.zeus.domain.interactor

interface BaseUseCase<in Parameter, out Result> {
    suspend fun invoke(parameter: Parameter): Result
}
