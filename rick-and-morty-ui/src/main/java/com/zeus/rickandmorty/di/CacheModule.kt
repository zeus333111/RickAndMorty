package com.zeus.rickandmorty.di

import android.content.Context
import com.zeus.cache.CharacterCacheImpl
import com.zeus.cache.dao.CharacterDao
import com.zeus.cache.database.CharacterDatabase
import com.zeus.cache.utils.CachePreferencesHelper
import com.zeus.data.repository.CharacterCache
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheModule {

    @Provides
    @Singleton
    fun provideCharacterCache(characterCacheImpl: CharacterCacheImpl): CharacterCache {
        return characterCacheImpl
    }

    @Provides
    @Singleton
    fun provideCharacterDao(characterDatabase: CharacterDatabase): CharacterDao {
        return characterDatabase.cacheCharacterDao()
    }

    @Provides
    @Singleton
    fun providePreferenceHelper(@ApplicationContext context: Context): CachePreferencesHelper {
        return CachePreferencesHelper(context)
    }

    @Provides
    @Singleton
    fun providesRoomDatabase(@ApplicationContext context: Context): CharacterDatabase {
        return CharacterDatabase.getInstance(context)
    }
}
