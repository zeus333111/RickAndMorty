package com.zeus.remoteretrofit.mappers

import com.zeus.data.models.CharacterEntity
import com.zeus.data.models.LocationEntity
import com.zeus.remoteretrofit.models.CharacterModel
import com.zeus.remoteretrofit.models.LocationModel

internal fun CharacterModel.toCharacterEntity(): CharacterEntity {
    return CharacterEntity(
        id = this.id.toString(),
        name = this.name,
        status = this.status,
        species = this.species,
        type = this.type,
        gender = this.gender,
        origin = this.origin.toLocationEntity(),
        location = this.location.toLocationEntity(),
        image = this.image,
        created = this.created,
    )
}

internal fun LocationModel.toLocationEntity(): LocationEntity {
    return LocationEntity(
        id = "",
        name = this.name,
        type = "",
        dimension = "",
        created = "",
    )
}
