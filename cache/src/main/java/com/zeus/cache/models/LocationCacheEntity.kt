package com.zeus.cache.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.zeus.cache.utils.CacheConstants

@Entity(tableName = CacheConstants.CHARACTER_LOCATION_TABLE_NAME)
data class LocationCacheEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val type: String,
    val dimension: String,
    val created: String
)
