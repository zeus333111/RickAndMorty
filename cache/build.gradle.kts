import dependencies.CacheDep

plugins {
    id(Config.Plugins.androidLibrary)
    id(Config.Plugins.kotlinAndroid)
    id(Config.Plugins.kapt)
}

android {
    namespace = Config.Cache.namespace
    compileSdk = Config.Android.compileSdkVersion

    defaultConfig {
        minSdk = Config.Android.minSdkVersion

        testInstrumentationRunner = Config.testRunner
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = Versions.sourceCompatibility
        targetCompatibility = Versions.targetCompatibility
    }
    kotlinOptions {
        jvmTarget = Versions.kotlinJvmTarget
    }
}

dependencies {

    implementation(project(Modules.data))

    implementation(CacheDep.kotlin)
    implementation(CacheDep.javax)

    api(CacheDep.room)
    kapt(CacheDep.romKapt)

    testImplementation(CacheDep.Test.assertJ)
    testImplementation(CacheDep.Test.coroutines)
    testImplementation(CacheDep.Test.junit)
    testImplementation(CacheDep.Test.android)
}
