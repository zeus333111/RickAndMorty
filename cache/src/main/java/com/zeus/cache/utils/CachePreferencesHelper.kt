package com.zeus.cache.utils

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

open class CachePreferencesHelper @Inject constructor(
    context: Context
) {
    companion object {
        private const val PREF_NAME = "cache_pref"
        private const val LAST_CACHE_KEY = "last=cache"
    }

    private val preferences: SharedPreferences =
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    var lastCache: Long
        get() = preferences.getLong(LAST_CACHE_KEY, 0)
        set(lastCache) = preferences.edit().putLong(LAST_CACHE_KEY, lastCache).apply()
}
