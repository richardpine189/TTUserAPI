package com.user.handlers

import com.user.models.User
import io.ktor.client.request.forms.*
import io.ktor.http.*
import io.ktor.server.request.*
import io.ktor.server.testing.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.decodeFromString
import org.junit.Test
import kotlin.test.assertEquals

class LogInHandlerShould {

    @Test
    fun `return user when login requested`() : Unit = withTestApplication{

        // Arrange
        val user = User(1, "Theo", "test")

        // Act
        handleRequest(HttpMethod.Post, "/logIn") {
            setBody(listOf("userName" to user.name).formUrlEncode())
        }.apply {
            // Assert
            assertEquals(user, Json.decodeFromString<User>(response.content!!))
        }
    }
}