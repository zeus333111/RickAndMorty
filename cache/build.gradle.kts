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
        targetSdk = Config.Android.targetSdkVersion

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
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
