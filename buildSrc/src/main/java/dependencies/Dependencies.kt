package dependencies

import Versions

object Dependencies {

    object KotlinDep {
        const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinVersion}"
    }

    object CoreDep {
        const val core = "androidx.core:core-ktx:${Versions.coreKtx}"
        const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
        const val material = "com.google.android.material:material:${Versions.material}"
        const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
        const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
        const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragment}"
        const val navigation = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
        const val navigationUI = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    }

    object JavaDep {
        const val javax = "javax.inject:javax.inject:${Versions.javaxInjectVersion}"
    }

    object TestDep {
        const val junit = "junit:junit:${Versions.jUnit}"
        const val coroutinesTest =
            "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesTestVersion}"
        const val mockitoKotlin =
            "org.mockito.kotlin:mockito-kotlin:${Versions.mockitoKotlinVersion}"
        const val mockitoInline = "org.mockito:mockito-inline:${Versions.mockitoInlineVersion}"
        const val assertJ = "org.assertj:assertj-core:${Versions.assertJVersion}"
        const val kotlinTest = "org.jetbrains.kotlin:kotlin-test:${Versions.kotlinVersion}"
        const val turbine = "app.cash.turbine:turbine:${Versions.turbineVersion}"
    }

    object AndroidTest {
        const val junit = "androidx.test.ext:junit:${Versions.androidJunit}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
        const val composeJUnit = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
        const val archTest = "androidx.arch.core:core-testing:${Versions.archTest}"
    }

    object DebugDep {
        const val ui = "androidx.compose.ui:ui-tooling:${Versions.compose}"
        const val uiTest = "androidx.compose.ui:ui-test-manifest:${Versions.compose}"
    }

    object Apollo {
        const val apolloRuntime = "com.apollographql.apollo3:apollo-runtime:${Versions.apollo}"

    }

    object OkHttpDep {
        const val loggingInterception = "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"
    }

    object HiltDep {
        const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
        const val hiltKapt = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
        const val navigationCompose = "androidx.hilt:hilt-navigation-compose:${Versions.navigationComposerHilt}"
    }

    object ComposeDep {
        const val material = "androidx.compose.material:material:${Versions.materialCompose}"
        const val ui = "androidx.compose.ui:ui:${Versions.compose}"
        const val toolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
        const val activityCompose = "androidx.activity:activity-compose:${Versions.activityCompose}"
        const val navigation= "androidx.navigation:navigation-compose:${Versions.navComposer}"
        const val composeRuntime = "androidx.compose.runtime:runtime:${Versions.compose}"
        const val coil = "io.coil-kt:coil-compose:${Versions.coil}"
        const val liveData = "androidx.compose.runtime:runtime-livedata:${Versions.livedata}"
    }

    object CoroutineDep {
        const val coroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutineCoreVersion}"
        const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutineAndroidVersion}"
    }

    object Room {
        const val roomRuntime = "androidx.room:room-runtime:${Versions.roomVersion}"
        const val roomKapt = "androidx.room:room-compiler:${Versions.roomVersion}"
    }

    object Extras {
        const val coil = "io.coil-kt:coil:${Versions.coil}"
    }
}
