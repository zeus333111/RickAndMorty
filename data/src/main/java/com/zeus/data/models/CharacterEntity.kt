package com.zeus.data.models

data class CharacterEntity(
    val id: String,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: LocationEntity,
    val location: LocationEntity,
    val image: String,
    val created: String,
    val page: Int = 0,
)
