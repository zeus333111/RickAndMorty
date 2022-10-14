package com.zeus.remoteapollo.api

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.network.okHttpClient
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object ApiClient {

    fun createClient(isDebug: Boolean, baseUrl: String): ApolloClient {
        return ApolloClient.Builder()
            .serverUrl(baseUrl)
            .okHttpClient(createOkHttpClient(createHttpInterceptor(isDebug)))
            .build()
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
