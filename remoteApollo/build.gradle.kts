import dependencies.RemoteApolloDep

plugins {
    `java-library`
    id(Config.Plugins.kotlin)
    id(Config.Plugins.kapt)
    id(Config.Plugins.apollo)
}

/*android {
    compileSdk = Config.Android.targetSdkVersion
    namespace = Config.Apollo.namespace

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
}*/

configure<com.apollographql.apollo3.gradle.api.ApolloExtension> {
    packageName.set("com.zeus.apollo")
}

dependencies {

    implementation(project(Modules.data))

    implementation(RemoteApolloDep.javax)

    implementation(RemoteApolloDep.apollo)
    implementation(RemoteApolloDep.interceptor)

    testImplementation(RemoteApolloDep.test)
    testImplementation(RemoteApolloDep.mockito)
}
