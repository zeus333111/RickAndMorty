package com.zeus.remoteretrofit.models

import com.google.gson.annotations.SerializedName

data class ResponseModel(
    @SerializedName("info")
    val info: InfoModel,
    @SerializedName("results")
    val results: List<CharacterModel>,
)
