package com.zeus.remoteapollo.mappers

import com.zeus.apollo.GetCharactersQuery
import com.zeus.apollo.fragment.CharacterData
import com.zeus.apollo.fragment.LocationData
import com.zeus.data.models.CharacterEntity
import com.zeus.data.models.LocationEntity

internal fun GetCharactersQuery.Data?.toCharacterEntityList(): List<CharacterEntity> {
    return this?.characters?.results?.mapNotNull {
        it?.toCharacterEntity()
    } ?: emptyList()
}

internal fun GetCharactersQuery.Result.toCharacterEntity(): CharacterEntity {
    return this.characterData.toCharacterEntity()
}

internal fun CharacterData.toCharacterEntity(): CharacterEntity {
    return CharacterEntity(
        id = this.id ?: "",
        name = this.name ?: "",
        status = this.status ?: "",
        species = this.species ?: "",
        type = this.type ?: "",
        gender = this.gender ?: "",
        origin = this.origin?.locationData.toLocationEntity(),
        location = this.location?.locationData.toLocationEntity(),
        image = this.image ?: "",
        created = this.created ?: ""
    )
}

internal fun LocationData?.toLocationEntity(): LocationEntity {
    return LocationEntity(
        id = this?.id ?: "",
        name = this?.name ?: "",
        type = this?.type ?: "",
        dimension = this?.dimension ?: "",
        created = this?.created ?: ""
    )
}
