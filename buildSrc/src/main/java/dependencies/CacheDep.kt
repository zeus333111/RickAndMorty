package dependencies

object CacheDep {

    const val kotlin = Dependencies.KotlinDep.kotlin
    const val javax = Dependencies.JavaDep.javax
    const val room = Dependencies.Room.roomRuntime

    const val romKapt = Dependencies.Room.roomKapt

    object Test {
        const val junit = Dependencies.TestDep.junit
        const val coroutines = Dependencies.TestDep.coroutinesTest
        const val assertJ = Dependencies.TestDep.assertJ
        const val android = Dependencies.AndroidTest.junit
    }
}
