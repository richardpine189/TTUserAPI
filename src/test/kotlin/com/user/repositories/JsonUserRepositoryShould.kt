package com.user.repositories

import org.junit.Assert
import org.junit.Test

class JsonUserRepositoryShould {

    val repository : JsonUserRepository = JsonUserRepository("testUsers.json")

    @Test
    fun `SaveNewUser`() {
        TODO()
    }

    @Test
    fun `ReadUsers`() {
        var users = repository.getUsers()

        Assert.assertEquals(users.size, 2)
    }
}