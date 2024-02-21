package com.zeus.rickandmorty.di

import com.zeus.data.repository.CharacterRemote
import com.zeus.remoteapollo.api.ApiClient
import com.zeus.remoteapollo.api.RemoteApolloClient
import com.zeus.remoteapollo.repository.CharacterRemoteImpl
import com.zeus.remoteretrofit.api.RemoteRetrofitClient
import com.zeus.remoteretrofit.api.RetrofitServices
import com.zeus.rickandmorty.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import com.zeus.remoteretrofit.repository.CharacterRemoteImpl as CharacterRemoteRetrofitImpl

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @Provides
    @Singleton
    fun provideGraphQlClient(): RemoteApolloClient {
        return ApiClient.createClient(BuildConfig.DEBUG, BuildConfig.BASE_URL_GRAPHQL)
    }

    @Provides
    @Singleton
    fun provideRetrofitClient(): RetrofitServices {
        return RemoteRetrofitClient.create(BuildConfig.DEBUG, BuildConfig.BASE_URL_REST)
    }

    @Provides
    @Singleton
    fun provideCharacterRemote(characterRemoteApolloImpl: CharacterRemoteImpl, characterRemoteRetrofitImpl: CharacterRemoteRetrofitImpl): CharacterRemote {
        return if (BuildConfig.ENABLE_REST) {
            characterRemoteRetrofitImpl
        } else {
            characterRemoteApolloImpl
        }
    }
}
