package com.zeus.cache.mapper

import com.zeus.cache.models.CharacterCacheEntity
import com.zeus.cache.models.LocationCacheEntity
import com.zeus.data.models.CharacterEntity
import com.zeus.data.models.LocationEntity

internal fun CharacterCacheEntity.toCharacterEntity(): CharacterEntity {
    return CharacterEntity(
        id = this.id,
        name = this.name,
        status = this.status,
        species = this.species,
        type = this.type,
        gender = this.gender,
        origin = this.origin.toLocationCacheEntity(),
        location = this.location.toLocationCacheEntity(),
        image = this.image,
        created = this.created
    )
}

internal fun LocationCacheEntity.toLocationCacheEntity(): LocationEntity {
    return LocationEntity(
        id = this.id,
        name = this.name,
        type = this.type,
        dimension = this.dimension,
        created = this.created
    )
}

internal fun CharacterEntity.toCharacterCacheEntity(): CharacterCacheEntity {
    return CharacterCacheEntity(
        id = this.id,
        name = this.name,
        status = this.status,
        species = this.species,
        type = this.type,
        gender = this.gender,
        origin = this.origin.toLocationCacheEntity(),
        location = this.location.toLocationCacheEntity(),
        image = this.image,
        created = this.created,
        page = this.page
    )
}

internal fun LocationEntity.toLocationCacheEntity(): LocationCacheEntity {
    return LocationCacheEntity(
        id = this.id,
        name = this.name,
        type = this.type,
        dimension = this.dimension,
        created = this.created
    )
}
