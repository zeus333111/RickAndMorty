package com.zeus.domain.repository

import com.zeus.domain.models.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    suspend fun getCharacters(page: Int): Flow<List<Character>>

    suspend fun saveCharacters(
        list: List<Character>,
        page: Int,
    )

    suspend fun getCharacter(id: String): Flow<Character?>
}
