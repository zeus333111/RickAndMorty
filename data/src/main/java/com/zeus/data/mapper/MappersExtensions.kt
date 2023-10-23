package com.zeus.data.mapper

import com.zeus.data.models.CharacterEntity
import com.zeus.data.models.LocationEntity
import com.zeus.domain.models.Character
import com.zeus.domain.models.CharacterLocation

internal fun CharacterEntity.toCharacter(): Character {
    return Character(
        id = this.id,
        name = this.name,
        status = this.status,
        species = this.species,
        type = this.type,
        gender = this.gender,
        origin = this.origin.toCharacterLocation(),
        location = this.location.toCharacterLocation(),
        image = this.image,
        created = this.created
    )
}

internal fun LocationEntity.toCharacterLocation(): CharacterLocation {
    return CharacterLocation(
        id = this.id,
        name = this.name,
        type = this.type,
        dimension = this.dimension,
        created = this.created
    )
}

internal fun Character.toCharacterEntity(): CharacterEntity {
    return CharacterEntity(
        id = this.id,
        name = this.name,
        status = this.status,
        species = this.species,
        type = this.type,
        gender = this.gender,
        origin = this.origin.toLocationEntity(),
        location = this.location.toLocationEntity(),
        image = this.image,
        created = this.created
    )
}

internal fun CharacterLocation.toLocationEntity(): LocationEntity {
    return LocationEntity(
        id = this.id,
        name = this.name,
        type = this.type,
        dimension = this.dimension,
        created = this.created
    )
}
