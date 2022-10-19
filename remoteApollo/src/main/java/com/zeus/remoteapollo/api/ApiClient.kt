package com.zeus.remoteapollo.api

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.network.okHttpClient
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object ApiClient : RemoteApolloClient {

    private lateinit var client: ApolloClient

    override fun getClient(): ApolloClient {
        return client
    }

    fun createClient(isDebug: Boolean, baseUrl: String): ApiClient {
        client = ApolloClient.Builder()
            .serverUrl(baseUrl)
            .okHttpClient(createOkHttpClient(createHttpInterceptor(isDebug)))
            .build()
        return this
    }

    private fun createOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    private fun createHttpInterceptor(isDebug: Boolean): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = if (isDebug) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }
    }
}
