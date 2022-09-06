package dependencies

object RemoteApolloDep {

    val test = Dependencies.TestDep.junit
    val apollo = Dependencies.Apollo.apolloRuntime
    val interceptor = Dependencies.OkHttpDep.loggingInterception

    const val hilt = Dependencies.HiltDep.hilt
    const val hiltKapt = Dependencies.HiltDep.hiltKapt
}
