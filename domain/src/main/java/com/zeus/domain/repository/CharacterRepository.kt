package com.zeus.domain.repository

import com.zeus.domain.models.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    suspend fun getCharacters(): Flow<List<Character>>
}
