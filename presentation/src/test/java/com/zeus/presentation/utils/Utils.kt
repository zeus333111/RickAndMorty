package com.zeus.presentation.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

fun <T> LiveData<T>.getOrAwaitValue(
    time: Long = 2,
    timeUnit: TimeUnit = TimeUnit.SECONDS,
): T {
    var data: T? = null
    val latch = CountDownLatch(1)
    val observer = object : Observer<T> {
        override fun onChanged(value: T) {
            if (data != value) {
                data = value
                latch.countDown()
                this@getOrAwaitValue.removeObserver(this)
            }
        }
    }

    this.observeForever(observer)

    // Don't wait indefinitely if the LiveData is not set.
    if (!latch.await(time, timeUnit)) {
        throw TimeoutException("LiveData value was never set.")
    }

    @Suppress("UNCHECKED_CAST")
    return data as T
}

suspend fun <T> LiveData<T>.observeForTesting(block: suspend () -> Unit) {
    val observer = Observer<T> { }
    try {
        observeForever(observer)
        block()
    } finally {
        removeObserver(observer)
    }
}

fun <T> LiveData<T>.captureValues(
    time: Long = 5,
    timeUnit: TimeUnit = TimeUnit.SECONDS,
): List<T> {
    val values = mutableListOf<T>()
    val latch = CountDownLatch(1)
    val observer = Observer<T> { value ->
        values.add(value)
        latch.countDown()
        // this@captureValues.removeObserver(this)
    }

    this.observeForever(observer)

    // Don't wait indefinitely if the LiveData is not set.
    if (!latch.await(time, timeUnit)) {
        throw TimeoutException("LiveData value was never set.")
    }

    @Suppress("UNCHECKED_CAST")
    return values
}
