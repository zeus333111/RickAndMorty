package com.zeus.remoteapollo.api

import com.apollographql.apollo3.ApolloClient

interface RemoteApolloClient {
    fun getClient(): ApolloClient
}
