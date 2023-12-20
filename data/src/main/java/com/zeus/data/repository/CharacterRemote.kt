package com.zeus.data.repository

import com.zeus.data.models.CharacterEntity

interface CharacterRemote {
    suspend fun getCharacters(page: Int): List<CharacterEntity>

    suspend fun getCharacter(id: String): CharacterEntity?
}
