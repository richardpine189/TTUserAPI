package com.user.repositories

import com.user.providers.GatewayConfig
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class JsonUserRepositoryShould {

    val repository : JsonUserRepository = JsonUserRepository(GatewayConfig.getTestUsersFilePath)

    @Test
    fun `ReadUsers`() {
        var users = repository.getUsers()

        assertEquals(users.size, 2)
    }

    @Test
    fun `Get One User by userName`()
    {
        var resultUser = repository.getUserByName("Ricardo")

        assertNotNull(resultUser)
    }
}