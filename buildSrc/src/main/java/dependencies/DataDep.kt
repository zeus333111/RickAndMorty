package dependencies

object DataDep {

    const val kotlin = Dependencies.KotlinDep.kotlin
    const val coroutineCore = Dependencies.CoroutineDep.coroutineCore
    const val javaX = Dependencies.JavaDep.javax

    val testDependencies = listOf(
        Dependencies.TestDep.junit,
        Dependencies.TestDep.coroutinesTest,
        Dependencies.TestDep.mockitoKotlin,
        Dependencies.TestDep.mockitoInline,
        Dependencies.TestDep.assertJ,
        Dependencies.TestDep.kotlinTest,
        Dependencies.TestDep.turbine
    )
}
