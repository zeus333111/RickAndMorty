package com.zeus.remoteapollo.mappers

import com.zeus.apollo.GetCharactersQuery
import com.zeus.data.models.LocationEntity
import javax.inject.Inject

class LocationEntityMapper @Inject constructor() :
    EntityMapper<GetCharactersQuery.Location?, LocationEntity> {
    override fun mapFromModel(model: GetCharactersQuery.Location?): LocationEntity {
        return LocationEntity(
            id = model?.id ?: "",
            name = model?.name ?: "",
            type = model?.type ?: "",
            dimension = model?.dimension ?: "",
            created = model?.created ?: ""
        )
    }
}
