package com.zeus.cache.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.zeus.cache.utils.CacheConstants

@Entity(tableName = CacheConstants.CHARACTER_TABLE_NAME)
data class CharacterCacheEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    @Embedded(prefix = "location_")
    val origin: LocationCacheEntity,
    @Embedded(prefix = "origin_")
    val location: LocationCacheEntity,
    val image: String,
    val created: String,
    val page: Int,
)
