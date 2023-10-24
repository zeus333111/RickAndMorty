import dependencies.RemoteApolloDep

plugins {
    `java-library`
    id(Config.Plugins.kotlin)
    id(Config.Plugins.kapt)
    id(Config.Plugins.apollo)
}

java {
    sourceCompatibility = Versions.sourceCompatibility
    targetCompatibility = Versions.targetCompatibility
}

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
