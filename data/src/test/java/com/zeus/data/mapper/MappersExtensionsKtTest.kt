package com.zeus.data.mapper

import com.zeus.data.utils.characterDomain
import com.zeus.data.utils.characterEntity
import com.zeus.data.utils.locationDomain1
import com.zeus.data.utils.locationEntity1
import junit.framework.TestCase.assertEquals
import org.junit.Test

class MappersExtensionsKtTest {
    @Test
    fun `test character entity to character domain`() {
        val test = characterEntity.toCharacter()

        assertEquals(test, characterDomain)
    }

    @Test
    fun `test location entity to location domain `() {
        val test = locationEntity1.toCharacterLocation()

        assertEquals(test, locationDomain1)
    }

    @Test
    fun `test character domain to character entity`() {
        val test = characterDomain.toCharacterEntity()

        assertEquals(test, characterEntity)
    }

    @Test
    fun `test character location domain to location entity`() {
        val test = locationDomain1.toLocationEntity()

        assertEquals(test, locationEntity1)
    }
}
