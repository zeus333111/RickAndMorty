package com.zeus.cache.mapper

import com.zeus.cache.models.LocationCacheEntity
import com.zeus.data.models.LocationEntity
import javax.inject.Inject

class LocationCacheMapper @Inject constructor() : CacheMapper<LocationCacheEntity, LocationEntity> {
    override fun mapFromCache(type: LocationCacheEntity): LocationEntity {
        return LocationEntity(
            id = type.id,
            name = type.name,
            type = type.type,
            dimension = type.dimension,
            created = type.created
        )
    }

    override fun mapToCache(type: LocationEntity): LocationCacheEntity {
        return LocationCacheEntity(
            id = type.id,
            name = type.name,
            type = type.type,
            dimension = type.dimension,
            created = type.created
        )
    }
}
