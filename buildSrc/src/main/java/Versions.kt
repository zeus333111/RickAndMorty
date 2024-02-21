import org.gradle.api.JavaVersion

object Versions {

    const val compose = "1.5.1"
    const val kotlinVersion = "1.9.0"
    const val agpVersion = "8.2.2"

    //Plugins
    const val androidApplication = agpVersion
    const val androidLibrary = agpVersion
    const val kotlinAndroid = kotlinVersion
    const val kapt = kotlinVersion
    const val hilt = "2.48.1"
    const val apollo = "3.6.2"
    const val retrofit = "2.9.0"
    const val gson = "2.9.0"
    const val ktlint = "12.0.3"
    const val jvm = kotlinVersion
    const val safeArgs = "2.5.3"

    //Core dependencies
    const val coreKtx = "1.12.0"
    const val appcompat = "1.6.1"
    const val material = "1.10.0"
    const val lifecycle = "2.6.2"
    const val constraintLayout = "2.1.4"
    const val fragment = "1.6.1"
    const val navigation = "2.5.3"

    //Javax Inject
    const val javaxInjectVersion = "1"

    //Test dependencies
    const val jUnit = "4.13.2"
    const val coroutinesTestVersion = "1.4.3"
    const val mockitoKotlinVersion = "5.2.1"
    const val mockitoInlineVersion = "5.2.0"
    const val assertJVersion = "3.11.1"
    const val turbineVersion = "1.0.0"

    //Android Test
    const val androidJunit = "1.1.3"
    const val espresso = "3.4.0"
    const val archTest = "2.1.0"

    //OkHttp dependencies
    const val loggingInterceptor = "5.0.0-alpha.5"

    //Compose
    const val materialCompose = "1.3.0-rc01"
    const val activityCompose = "1.5.1"
    const val navComposer = "2.5.2"
    const val navigationComposerHilt = "1.0.0"
    const val coil = "2.4.0"
    const val livedata = "1.3.2"

    //Coroutines
    const val coroutineCoreVersion = "1.7.3"
    const val coroutineAndroidVersion = "1.7.3"

    //Room
    const val roomVersion = "2.4.3"

    val sourceCompatibility = JavaVersion.VERSION_17
    val targetCompatibility =  JavaVersion.VERSION_17
    const val kotlinJvmTarget = "17"
}
