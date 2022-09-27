package com.user.handlers

import com.user.interfaces.IGetOpponent
import com.user.models.User
import io.ktor.http.*
import io.ktor.server.testing.*
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import org.junit.Test

class GetOpponentHandlerShould {

    @Test
    fun `return opponent when requested`() : Unit = withTestApplication{

        //Arrange
        val userName = "Jesus"
        val opponentName = "Ricardo"
        val opponent = User(1, opponentName, "test")

        val getOpponentUseCase : IGetOpponent = mockk()
        coEvery { getOpponentUseCase(userName) } returns opponent
        val handler = GetOpponentHandler(getOpponentUseCase)
        handler.routing(application)

        // Act
        handleRequest(HttpMethod.Get, "/getOpponent/${userName}").apply {
            // Assert
            assertEquals(HttpStatusCode.OK, response.status())
            assertEquals(opponentName, response.content)
        }
    }
}