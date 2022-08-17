package com.user;

import com.user.interfaces.IUserRepository
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString
import kotlinx.serialization.decodeFromString
import org.junit.BeforeClass
import org.mockito.kotlin.mock
import kotlin.test.Test
import kotlin.test.assertEquals

class UserRoutingShould {

    @Test
    fun testGetUsers() = testApplication {
        application {
            userRouting()
        }

        client.get("/user").apply {
            TODO("Please write your test here")
        }
    }

    @Test
    fun getUserById() = testApplication {
        application {
            userRouting()
        }

        client.get("/user/*").apply {
            TODO("Please write your test here")
        }
    }

    @Test
    fun postUser() = testApplication {
        application {
            userRouting()
        }

        client.post("/user").apply {
            TODO("Please write your test here")
        }
    }

    @Test
    fun editUserWithPut() = testApplication {
        application {
            userRouting()
        }

        client.put("/user").apply {
            TODO("Please write your test here")
        }
    }

    @Test
    fun deleteUserById() = testApplication {
        application {
            userRouting()
        }

        client.delete("/user/{id}").apply {
            TODO("Please write your test here")
        }
    }

    @Test
    fun `Get victory count`() = testApplication {
        application {
            userRouting()
        }

        val expectedVictories = 3
        val userId = 7

        val response = client.get("/user/victories/${userId}")

        val userVictories = Json.decodeFromString<Int>(response.bodyAsText())

        assertEquals(expectedVictories, userVictories)
    }
}