package com.zeus.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.zeus.cache.models.CharacterCacheEntity

@Dao
interface CharacterDao {

    @Query("SELECT * FROM characters WHERE page = :page")
    fun getCharacters(page: Int): List<CharacterCacheEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveCharacters(listOfCharacters: List<CharacterCacheEntity>)

    @Query("SELECT * FROM characters WHERE id = :id")
    fun getCharacter(id: String): CharacterCacheEntity?
}
