package dependencies

object PresentationDep {
    const val core = Dependencies.CoreDep.core
    const val viewModel = Dependencies.CoreDep.viewModel
    const val lifecycle = Dependencies.CoreDep.lifecycle
    const val liveData = Dependencies.CoreDep.liveData
    const val coroutines = Dependencies.CoroutineDep.coroutinesAndroid
    const val composeRuntime = Dependencies.ComposeDep.composeRuntime

    const val hilt = Dependencies.HiltDep.hilt
    const val hiltKapt = Dependencies.HiltDep.hiltKapt

    object Test {
        const val junit = Dependencies.TestDep.junit
        const val coroutines = Dependencies.TestDep.coroutinesTest
        const val mockitoKotlin = Dependencies.TestDep.mockitoKotlin
        const val mockitoInline = Dependencies.TestDep.mockitoInline
        const val assertJ = Dependencies.TestDep.assertJ
    }
}
