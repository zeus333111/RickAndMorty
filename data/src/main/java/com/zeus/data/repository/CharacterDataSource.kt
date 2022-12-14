package com.zeus.data.repository

import com.zeus.data.models.CharacterEntity

interface CharacterDataSource {
    suspend fun getCharacters(page: Int): List<CharacterEntity>
    suspend fun saveCharacter(list: List<CharacterEntity>)

    suspend fun isCached(page: Int): Boolean
}
