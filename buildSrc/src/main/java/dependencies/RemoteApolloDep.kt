package dependencies

object RemoteApolloDep {

    const val test = Dependencies.TestDep.junit
    const val mockito = Dependencies.TestDep.mockitoKotlin
    const val apollo = Dependencies.Apollo.apolloRuntime
    const val interceptor = Dependencies.OkHttpDep.loggingInterception
    const val javax = Dependencies.JavaDep.javax
}
