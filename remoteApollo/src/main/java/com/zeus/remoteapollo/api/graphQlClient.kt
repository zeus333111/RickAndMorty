package com.zeus.remoteapollo.api

import com.apollographql.apollo3.ApolloClient

interface graphQlClient {
    fun getClient(): ApolloClient
}
