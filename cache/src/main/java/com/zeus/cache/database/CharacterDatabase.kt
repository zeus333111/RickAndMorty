package com.zeus.cache.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.zeus.cache.dao.CharacterDao
import com.zeus.cache.models.CharacterCacheEntity
import com.zeus.cache.models.LocationCacheEntity
import com.zeus.cache.utils.CacheConstants
import com.zeus.cache.utils.Migrations
import javax.inject.Inject

@Database(
    entities = [CharacterCacheEntity::class, LocationCacheEntity::class],
    version = Migrations.DB_VERSION,
    exportSchema = false
)
abstract class CharacterDatabase @Inject constructor() : RoomDatabase() {

    abstract fun cacheCharacterDao(): CharacterDao

    companion object {
        @Volatile
        private var INSTANCE: CharacterDatabase? = null

        fun getInstance(context: Context): CharacterDatabase = INSTANCE ?: synchronized(this) {
            INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            CharacterDatabase::class.java,
            CacheConstants.DB_NAME
        ).build()
    }
}
