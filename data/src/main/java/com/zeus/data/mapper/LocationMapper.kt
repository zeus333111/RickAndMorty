package com.zeus.data.mapper

import com.zeus.data.models.LocationEntity
import javax.inject.Inject
import com.zeus.domain.models.CharacterLocation as CharacterLocation1

class LocationMapper @Inject constructor() : Mapper<LocationEntity, CharacterLocation1> {
    override fun mapFromEntity(type: LocationEntity): CharacterLocation1 {
        return CharacterLocation1(
            id = type.id,
            name = type.name,
            type = type.type,
            dimension = type.dimension,
            created = type.created
        )
    }

    override fun mapToEntity(type: CharacterLocation1): LocationEntity {
        return LocationEntity(
            id = type.id,
            name = type.name,
            type = type.type,
            dimension = type.dimension,
            created = type.created
        )
    }
}
