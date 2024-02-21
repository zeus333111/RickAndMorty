import dependencies.UiDep

plugins {
    id(Config.Plugins.androidApplication)
    id(Config.Plugins.kotlinAndroid)
    id(Config.Plugins.hilt)
    id(Config.Plugins.kapt)
}

android {
    namespace = Environments.Release.appId
    compileSdk = Config.Android.compileSdkVersion

    defaultConfig {
        applicationId = Environments.Release.appId
        minSdk = Config.Android.minSdkVersion
        targetSdk = Config.Android.targetSdkVersion
        versionCode = Environments.Release.appVersionCode
        versionName = Environments.Release.appVersionName

        testInstrumentationRunner = Config.testRunner
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
            buildConfigField("String", "BASE_URL_GRAPHQL", "\"https://rickandmortyapi.com/graphql\"")
            buildConfigField("String", "BASE_URL_REST", "\"https://rickandmortyapi.com/api/\"")
            buildConfigField("boolean", "ENABLE_REST", "true")
        }
        debug {
            buildConfigField("String", "BASE_URL_GRAPHQL", "\"https://rickandmortyapi.com/graphql\"")
            buildConfigField("String", "BASE_URL_REST", "\"https://rickandmortyapi.com/api/\"")
            buildConfigField("boolean", "ENABLE_REST", "true")
        }
    }
    compileOptions {
        sourceCompatibility = Versions.sourceCompatibility
        targetCompatibility = Versions.targetCompatibility
    }
    kotlinOptions {
        jvmTarget = Versions.kotlinJvmTarget
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }
}

dependencies {

    implementation(project(Modules.domain))
    implementation(project(Modules.data))
    implementation(project(Modules.presentation))
    implementation(project(Modules.apollo))
    implementation(project(Modules.retrofit))
    implementation(project(Modules.cache))

    UiDep.core.forEach {
        implementation(it)
    }

    implementation(UiDep.hilt)
    kapt(UiDep.hiltKapt)
    implementation(UiDep.hiltNavigation)

    UiDep.compose.forEach {
        implementation(it)
    }

    testImplementation(UiDep.testJunit)

    UiDep.androidTest.forEach {
        androidTestImplementation(it)
    }

    UiDep.debugDep.forEach {
        debugImplementation(it)
    }
}
