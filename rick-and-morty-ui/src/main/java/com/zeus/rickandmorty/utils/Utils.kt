package com.zeus.rickandmorty.utils

import java.text.SimpleDateFormat
import java.util.Locale

internal fun dateFormatter(dateString: String): String {
    val inputFormatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
    val date = inputFormatter.parse(dateString)
    val outputFormatter = SimpleDateFormat("yyy-MM-dd", Locale.getDefault())
    return date?.let { outputFormatter.format(it) } ?: ""
}
