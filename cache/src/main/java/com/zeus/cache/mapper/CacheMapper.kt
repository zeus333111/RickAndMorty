package com.zeus.cache.mapper

interface CacheMapper<M, E> {
    fun mapFromCache(type: M): E
    fun mapToCache(type: E): M
}
