package com.zeus.cache.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.zeus.cache.utils.CacheConstants

@Deprecated("not needed")
@Entity(tableName = CacheConstants.ORIGIN_LOCATION_TABLE_NAME)
data class OriginCacheEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val created: String
)
