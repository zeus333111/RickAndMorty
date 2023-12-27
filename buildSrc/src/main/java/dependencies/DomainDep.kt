package dependencies

object DomainDep {
    const val kotlin = Dependencies.KotlinDep.kotlin
    const val javax = Dependencies.JavaDep.javax
    const val coroutineCore = Dependencies.CoroutineDep.coroutineCore

    val test = listOf(
        Dependencies.TestDep.junit,
        Dependencies.TestDep.coroutinesTest,
        Dependencies.TestDep.mockitoKotlin,
        Dependencies.TestDep.mockitoInline,
        Dependencies.TestDep.assertJ,
        Dependencies.TestDep.turbine
    )
}
