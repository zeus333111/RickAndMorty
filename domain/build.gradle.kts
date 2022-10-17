import dependencies.DomainDep

plugins {
    `java-library`
    id(Config.Plugins.kotlin)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {

    implementation(DomainDep.kotlin)
    implementation(DomainDep.coroutineCore)
    implementation(DomainDep.javax)

    DomainDep.test.forEach {
        testImplementation(it)
    }
}
