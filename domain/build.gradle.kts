import dependencies.DomainDep

plugins {
    `java-library`
    id(Config.Plugins.kotlin)
}

java {
    sourceCompatibility = Versions.sourceCompatibility
    targetCompatibility = Versions.targetCompatibility
}

dependencies {

    implementation(DomainDep.kotlin)
    implementation(DomainDep.coroutineCore)
    implementation(DomainDep.javax)

    DomainDep.test.forEach {
        testImplementation(it)
    }
}
