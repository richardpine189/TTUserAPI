package com.user.handlers

import com.user.models.User
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.server.testing.*
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class GetOpponentHandlerShould {

    @Test
    fun `Return a user when request opponent`()
    {
        testApplication {
            val response = client.get("/getOpponent/Ricardo")
            assertEquals(HttpStatusCode.OK, response.status)
            assertTrue { response.body<User>() is User }
        }
    }
}