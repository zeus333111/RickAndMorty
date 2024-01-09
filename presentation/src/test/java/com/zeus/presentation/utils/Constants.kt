package com.zeus.presentation.utils

import com.zeus.domain.models.Character
import com.zeus.domain.models.CharacterLocation

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
