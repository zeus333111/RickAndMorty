package com.zeus.remoteapollo.mappers

interface EntityMapper<M, E> {
    fun mapFromModel(model: M): E
}
