object Config {

    object Android {
        const val minSdkVersion = 26
        const val targetSdkVersion = 33
        const val compileSdkVersion = 34
    }

    object Plugins {
        const val kotlin = "kotlin"
        const val androidApplication = "com.android.application"
        const val androidLibrary = "com.android.library"
        const val kotlinAndroid = "org.jetbrains.kotlin.android"
        const val kapt = "org.jetbrains.kotlin.kapt"
        const val hilt = "com.google.dagger.hilt.android"
        const val apollo = "com.apollographql.apollo3"
        const val ktlint = "org.jlleitschuh.gradle.ktlint"
        const val safeArgs = "androidx.navigation.safeargs.kotlin"
    }

    const val testRunner = "androidx.test.runner.AndroidJUnitRunner"

    object Apollo {
        const val namespace = "com.zeus.remoteapollo"
    }

    object Presentation {
        const val namespace = "com.zeus.presentation"
    }

    object Cache {
        const val namespace = "com.zeus.cache"
    }
}
