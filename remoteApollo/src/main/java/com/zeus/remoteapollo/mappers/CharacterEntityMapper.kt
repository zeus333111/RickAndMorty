package com.zeus.remoteapollo.mappers

import com.zeus.apollo.GetCharactersQuery
import com.zeus.data.models.CharacterEntity
import javax.inject.Inject

class CharacterEntityMapper @Inject constructor() : EntityMapper<GetCharactersQuery.Result?, CharacterEntity> {
    override fun mapFromModel(model: GetCharactersQuery.Result?): CharacterEntity {
        return CharacterEntity(
            name = model?.name ?: ""
        )
    }
}
