package com.user.handlers

import com.user.interfaces.Handler
import com.user.interfaces.ILogInUseCase
import com.user.users
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.util.pipeline.*

class LoginHandler(val logInUseCase : ILogInUseCase) : Handler {

    private val PATH = "/logIn"

    override fun routing(a: Application) {
        // Login by username
        a.routing {
            route(PATH) {
                post { logIn() }
            }
        }
    }

    suspend fun PipelineContext<Unit, ApplicationCall>.logIn() {
        val formParameters = call.receiveParameters()
        val username = formParameters["userName"].toString()

        val result = when (username) {
            null -> call.respond(HttpStatusCode.BadRequest, "Must send a Username")
            else -> {
                val user = logInUseCase(username)
                when (user) {
                    null -> call.respond(HttpStatusCode.NotFound, "User not found")
                    // Coin assignment is hardcoded here
                    else -> {
                        user.coin = (5..20).random()
                        call.respond(user)
                    }
                }
            }
        }
    }
}