import dependencies.DataDep

plugins {
    id(Config.Plugins.kotlin)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {

    implementation(DataDep.kotlin)
    implementation(DataDep.coroutineCore)
    implementation(DataDep.javaX)

    DataDep.testDependencies.forEach {
        testImplementation(it)
    }
}
