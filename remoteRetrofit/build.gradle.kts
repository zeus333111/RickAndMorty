import dependencies.RemoteRetrofitDep

plugins {
    `java-library`
    id(Config.Plugins.kotlin)
    id(Config.Plugins.kapt)
}

java {
    sourceCompatibility = Versions.sourceCompatibility
    targetCompatibility = Versions.targetCompatibility
}

dependencies {

    implementation(project(Modules.data))

    implementation(RemoteRetrofitDep.javax)

    implementation(RemoteRetrofitDep.retrofit)
    implementation(RemoteRetrofitDep.interceptor)
    implementation(RemoteRetrofitDep.gsonConverter)

    testImplementation(RemoteRetrofitDep.test)
    testImplementation(RemoteRetrofitDep.mockito)
}
