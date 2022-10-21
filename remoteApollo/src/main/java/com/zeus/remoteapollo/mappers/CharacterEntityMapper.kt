package com.zeus.remoteapollo.mappers

import com.zeus.apollo.GetCharactersQuery
import com.zeus.data.models.CharacterEntity
import javax.inject.Inject

class CharacterEntityMapper @Inject constructor(
    private val originEntityMapper: OriginEntityMapper,
    private val locationEntityMapper: LocationEntityMapper
) : EntityMapper<GetCharactersQuery.Result?, CharacterEntity> {

    override fun mapFromModel(model: GetCharactersQuery.Result?): CharacterEntity {
        return CharacterEntity(
            id = model?.id ?: "",
            name = model?.name ?: "",
            status = model?.status ?: "",
            species = model?.species ?: "",
            type = model?.type ?: "",
            gender = model?.gender ?: "",
            origin = originEntityMapper.mapFromModel(model?.origin),
            location = locationEntityMapper.mapFromModel(model?.location),
            image = model?.image ?: "",
            created = model?.created ?: ""
        )
    }
}
