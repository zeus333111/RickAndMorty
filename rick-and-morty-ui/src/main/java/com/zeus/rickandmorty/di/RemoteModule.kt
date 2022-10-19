package com.zeus.rickandmorty.di

import com.zeus.data.repository.CharacterRemote
import com.zeus.remoteapollo.api.ApiClient
import com.zeus.remoteapollo.api.RemoteApolloClient
import com.zeus.remoteapollo.repository.CharacterRemoteImpl
import com.zeus.rickandmorty.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @Provides
    @Singleton
    fun provideGraphQlClient(): RemoteApolloClient {
        return ApiClient.createClient(BuildConfig.DEBUG, BuildConfig.BASE_URL)
    }

    @Provides
    @Singleton
    fun provideCharacterRemote(characterRemoteImpl: CharacterRemoteImpl): CharacterRemote {
        return characterRemoteImpl
    }
}
