import dependencies.DataDep

plugins {
    id(Config.Plugins.kotlin)
}

java {
    sourceCompatibility = Versions.sourceCompatibility
    targetCompatibility = Versions.targetCompatibility
}

dependencies {

    implementation(project(Modules.domain))

    implementation(DataDep.kotlin)
    implementation(DataDep.coroutineCore)
    implementation(DataDep.javaX)

    DataDep.testDependencies.forEach {
        testImplementation(it)
    }
}
