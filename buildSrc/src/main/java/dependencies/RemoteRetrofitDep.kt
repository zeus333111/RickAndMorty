package dependencies

object RemoteRetrofitDep {
    const val test = Dependencies.TestDep.junit
    const val mockito = Dependencies.TestDep.mockitoKotlin
    const val retrofit = Dependencies.Retrofit.retrofit
    const val interceptor = Dependencies.OkHttpDep.loggingInterception
    const val javax = Dependencies.JavaDep.javax
    const val gsonConverter = Dependencies.Retrofit.gsonConverter
}
