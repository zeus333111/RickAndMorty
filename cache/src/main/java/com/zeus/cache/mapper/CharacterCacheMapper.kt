package com.zeus.cache.mapper

import com.zeus.cache.models.CharacterCacheEntity
import com.zeus.data.models.CharacterEntity
import javax.inject.Inject

class CharacterCacheMapper @Inject constructor(
    private val locationCacheMapper: LocationCacheMapper
) : CacheMapper<CharacterCacheEntity, CharacterEntity> {
    override fun mapFromCache(type: CharacterCacheEntity): CharacterEntity {
        return CharacterEntity(
            id = type.id,
            name = type.name,
            status = type.status,
            species = type.species,
            type = type.type,
            gender = type.gender,
            origin = locationCacheMapper.mapFromCache(type.origin),
            location = locationCacheMapper.mapFromCache(type.location),
            image = type.image,
            created = type.created
        )
    }

    override fun mapToCache(type: CharacterEntity): CharacterCacheEntity {
        return CharacterCacheEntity(
            id = type.id,
            name = type.name,
            status = type.status,
            species = type.species,
            type = type.type,
            gender = type.gender,
            origin = locationCacheMapper.mapToCache(type.origin),
            location = locationCacheMapper.mapToCache(type.location),
            image = type.image,
            created = type.created,
            page = type.page
        )
    }
}
