package com.user.repositories

import com.user.providers.GatewayConfig
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class JsonUserRepositoryShould {

    val repository : JsonUserRepository = JsonUserRepository(GatewayConfig.getTestUsersFilePath)

    @Test
    fun `SaveNewUser`() {
        repository.saveUsers()
    }

    @Test
    fun `ReadUsers`() {
        var users = repository.getUsers()

        assertEquals(users.size, 2)
    }

    @Test
    fun `Get One User by userName`()
    {
        var resultUser = repository.getUserByName("Rick pine")

        assertNotNull(resultUser)
    }

    @Test
    fun `Add Victory to User`()
    {
        val userName = "Theo"
        val user = repository.getUserByName(userName)
        val previousVictories = user.victories
        repository.addVictory(userName)
        val newUser = repository.getUserByName(userName)
        val currentVictories = newUser.victories

        assertEquals(previousVictories + 1, currentVictories)
    }
}