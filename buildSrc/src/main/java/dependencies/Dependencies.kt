package dependencies

object Dependencies {

    object CoreDep {
        const val core = "androidx.core:core-ktx:${Versions.coreKtx}"
        const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
        const val material = "com.google.android.material:material:${Versions.material}"
        const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    }

    object TestDep {
        const val junit = "junit:junit:${Versions.jUnit}"
    }

    object AndroidTest {
        const val junit = "androidx.test.ext:junit:${Versions.androidJunit}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
        const val composeJUnit = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
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
    }

    object ComposeDep {
        const val material = "androidx.compose.material3:material3:${Versions.materialCompose}"
        const val ui = "androidx.compose.ui:ui:${Versions.compose}"
        const val toolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
        const val activityCompose = "androidx.activity:activity-compose:${Versions.activityCompose}"
    }
}
