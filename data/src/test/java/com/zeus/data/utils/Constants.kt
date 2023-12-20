package com.zeus.data.utils

import com.zeus.data.models.CharacterEntity
import com.zeus.data.models.LocationEntity
import com.zeus.domain.models.Character
import com.zeus.domain.models.CharacterLocation

val locationEntity1 =
    LocationEntity(
        id = "testid",
        name = "earth",
        type = "planet",
        dimension = "0123456",
        created = "01/01/2023",
    )

val locationEntity2 =
    LocationEntity(
        id = "testid2",
        name = "earth",
        type = "planet",
        dimension = "0123456",
        created = "05/10/2023",
    )

val characterEntity =
    CharacterEntity(
        id = "someid",
        name = "test name",
        status = "test",
        species = "human",
        type = "test",
        gender = "male",
        location = locationEntity1,
        origin = locationEntity2,
        image = "someUrl",
        created = "01/01/2023",
    )

val locationDomain1 =
    CharacterLocation(
        id = "testid",
        name = "earth",
        type = "planet",
        dimension = "0123456",
        created = "01/01/2023",
    )

val locationDomain2 =
    CharacterLocation(
        id = "testid2",
        name = "earth",
        type = "planet",
        dimension = "0123456",
        created = "05/10/2023",
    )

val characterDomain =
    Character(
        id = "someid",
        name = "test name",
        status = "test",
        species = "human",
        type = "test",
        gender = "male",
        location = locationDomain1,
        origin = locationDomain2,
        image = "someUrl",
        created = "01/01/2023",
    )
