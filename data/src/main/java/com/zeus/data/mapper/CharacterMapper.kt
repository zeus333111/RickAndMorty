package com.zeus.data.mapper

import com.zeus.data.models.CharacterEntity
import com.zeus.domain.models.Character
import javax.inject.Inject

class CharacterMapper @Inject constructor() : Mapper<CharacterEntity, Character> {

    override fun mapFromEntity(type: CharacterEntity): Character {
        return Character(
            name = type.name
        )
    }

    override fun mapToEntity(type: Character): CharacterEntity {
        return CharacterEntity(
            name = type.name
        )
    }
}
