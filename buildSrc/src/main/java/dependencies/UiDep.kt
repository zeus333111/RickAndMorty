package dependencies

object UiDep {

    val core = listOf(
        Dependencies.CoreDep.core,
        Dependencies.CoreDep.lifecycle
    )

    const val hilt = Dependencies.HiltDep.hilt
    const val hiltKapt = Dependencies.HiltDep.hiltKapt
    const val hiltNavigation = Dependencies.HiltDep.navigationCompose

    val compose = listOf(
        Dependencies.ComposeDep.ui,
        Dependencies.ComposeDep.material,
        Dependencies.ComposeDep.toolingPreview,
        Dependencies.ComposeDep.activityCompose,
        Dependencies.ComposeDep.navigation
    )

    const val testJunit = Dependencies.TestDep.junit

    val androidTest = listOf(
        Dependencies.AndroidTest.junit,
        Dependencies.AndroidTest.espresso,
        Dependencies.AndroidTest.composeJUnit,

    )

    val debugDep = listOf(
        Dependencies.DebugDep.ui,
        Dependencies.DebugDep.uiTest
    )
}
