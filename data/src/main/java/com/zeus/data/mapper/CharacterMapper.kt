package com.zeus.data.mapper

import com.zeus.data.models.CharacterEntity
import com.zeus.domain.models.Character
import javax.inject.Inject

class CharacterMapper @Inject constructor(
    private val locationMapper: LocationMapper
) : Mapper<CharacterEntity, Character> {

    override fun mapFromEntity(type: CharacterEntity): Character {
        return Character(
            id = type.id,
            name = type.name,
            status = type.status,
            species = type.species,
            type = type.type,
            gender = type.gender,
            origin = locationMapper.mapFromEntity(type.origin),
            location = locationMapper.mapFromEntity(type.location),
            image = type.image,
            created = type.created
        )
    }

    override fun mapToEntity(type: Character): CharacterEntity {
        return CharacterEntity(
            id = type.id,
            name = type.name,
            status = type.status,
            species = type.species,
            type = type.type,
            gender = type.gender,
            origin = locationMapper.mapToEntity(type.origin),
            location = locationMapper.mapToEntity(type.location),
            image = type.image,
            created = type.created
        )
    }
}
