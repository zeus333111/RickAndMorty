package com.zeus.remoteretrofit.api

import com.zeus.remoteretrofit.models.CharacterModel
import com.zeus.remoteretrofit.models.ResponseModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitServices {

    @GET("character")
    suspend fun getCharacters(@Query("page") page: Int): ResponseModel

    @GET("character/{characterId}")
    suspend fun getCharacter(@Path("characterId") characterId: Int): CharacterModel
}
