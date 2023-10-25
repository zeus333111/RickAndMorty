package dependencies

object UIXmlDep {
    val core = listOf(
        Dependencies.CoreDep.core,
        Dependencies.CoreDep.appcompat,
        Dependencies.CoreDep.material,
        Dependencies.CoreDep.constraintLayout,
        Dependencies.CoreDep.viewModel,
        Dependencies.CoreDep.navigation,
        Dependencies.CoreDep.navigationUI
    )

    val hilt = Dependencies.HiltDep.hilt
    val hiltKapt = Dependencies.HiltDep.hiltKapt

    val coil = Dependencies.Extras.coil

    val testJunit = Dependencies.TestDep.junit

    val androidTest = listOf(
        Dependencies.AndroidTest.junit,
        Dependencies.AndroidTest.espresso
    )
}
