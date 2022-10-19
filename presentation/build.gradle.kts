import dependencies.PresentationDep

plugins {
    id(Config.Plugins.androidLibrary)
    id(Config.Plugins.kotlinAndroid)
    id(Config.Plugins.kapt)
}

android {
    namespace = Config.Presentation.namespace
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

    implementation(project(Modules.domain))

    implementation(PresentationDep.core)
    implementation(PresentationDep.viewModel)
    implementation(PresentationDep.lifecycle)
    implementation(PresentationDep.liveData)
    implementation(PresentationDep.coroutines)
    implementation(PresentationDep.composeRuntime)

    implementation(PresentationDep.hilt)
    kapt(PresentationDep.hiltKapt)

    testImplementation(PresentationDep.Test.junit)
    testImplementation(PresentationDep.Test.coroutines)
    testImplementation(PresentationDep.Test.mockitoKotlin)
    testImplementation(PresentationDep.Test.mockitoInline)
    testImplementation(PresentationDep.Test.assertJ)
}
