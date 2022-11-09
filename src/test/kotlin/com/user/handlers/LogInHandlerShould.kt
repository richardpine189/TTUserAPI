package com.user.handlers
import com.user.interfaces.ILogInUseCase
import com.user.models.User
import com.user.providers.UseCaseProvider
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.request.*
import io.ktor.server.testing.*
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.serialization.json.Json
import kotlinx.serialization.decodeFromString
import org.junit.Test
import kotlin.test.assertEquals

class LogInHandlerShould {

    @Test
    fun `return user when login requested`() : Unit = withTestApplication{

        // Arrange
        installSerialization()
        val user = User(1, "Theo", "theokatz@gmail.com")


        val userLoginUseCase : ILogInUseCase =  mockk()

        val handler = LoginHandler(userLoginUseCase)

        coEvery {
            userLoginUseCase("Theo")
        } returns user

        handler.routing(application)
        // Act
        with(handleRequest(HttpMethod.Post, "/logIn") {

            setBody(listOf("userName" to user.name).formUrlEncode())
            addHeader(name = "Content-Type", value = ContentType.Application.FormUrlEncoded.toString())
        }) {
            // Assert
            assertEquals(user, Json.decodeFromString<User>(response.content!!))
        }
    }

    private fun TestApplicationEngine.installSerialization() {
        application.install(ContentNegotiation) {
            json(
                Json{
                    ignoreUnknownKeys = true
                }
            )
        }
    }
}
//'1', 'Theo', 'theokatz@gmail.com', '2600', '26'
//ContentType.Application.FormUrlEncoded.toString()