package com.user.handlers

import com.user.interfaces.IHandler
import com.user.interfaces.ILogInUseCase
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.util.pipeline.*

class LoginIHandler(val logInUseCase : ILogInUseCase) : IHandler {

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

        when (username) {
            null -> call.respond(HttpStatusCode.BadRequest, "Must send a Username")
            else -> {
                try
                {
                    val user = logInUseCase(username)
                    call.respond(user)
                }
                catch (e : Exception)
                {
                    call.respond(HttpStatusCode.NotFound, "User not found in Database.")
                }
            }
        }
    }
}