package com.zeus.data.repository

import com.zeus.data.models.CharacterEntity

interface CharacterDataSource {
    suspend fun getCharacters(): List<CharacterEntity>
}
