import dependencies.RemoteApolloDep

plugins {
    id(Config.Plugins.androidLibrary)
    id(Config.Plugins.kotlinAndroid)
    id(Config.Plugins.kapt)
    id(Config.Plugins.hilt)
    id(Config.Plugins.apollo)
}

android {
    compileSdk = Config.Android.targetSdkVersion

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
        debug {
            buildConfigField("String", "BASE_URL", "\"https://rickandmortyapi.com/graphql\"")
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

configure<com.apollographql.apollo3.gradle.api.ApolloExtension> {
    packageName.set("com.zeus.apollo")
}

dependencies {

    implementation(RemoteApolloDep.hilt)
    kapt(RemoteApolloDep.hiltKapt)

    implementation(RemoteApolloDep.apollo)
    implementation(RemoteApolloDep.interceptor)

    implementation(RemoteApolloDep.test)
}
