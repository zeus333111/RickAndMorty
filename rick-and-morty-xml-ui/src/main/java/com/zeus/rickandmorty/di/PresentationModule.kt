package com.zeus.rickandmorty.di

import com.zeus.presentation.utils.CoroutineContextProvider
import com.zeus.presentation.utils.CoroutineContextProviderImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PresentationModule {

    @Provides
    @Singleton
    fun providesCoroutinesContextProvider(coroutineContextProvider: CoroutineContextProviderImpl): CoroutineContextProvider {
        return coroutineContextProvider
    }
}
