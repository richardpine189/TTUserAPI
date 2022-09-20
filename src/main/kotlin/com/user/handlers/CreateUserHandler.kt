package com.user.handlers

import com.user.interfaces.Handler
import com.user.interfaces.ICreateUseCase
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.util.pipeline.*

class CreateUserHandler(val createUseCase : ICreateUseCase) : Handler {
    private val PATH = "/createUser"

    override fun routing(a: Application) {
        a.routing {
            route(PATH) {
                post { create() }
            }
        }
    }

    suspend fun PipelineContext<Unit, ApplicationCall>.create() {
        val formParameters = call.receiveParameters()
        val username = formParameters["userName"].toString()
        val email = formParameters["email"].toString()

        when (username) {
            null -> call.respond(HttpStatusCode.BadRequest, "Must send a Username")
            else -> {
                try
                {
                    val user = createUseCase(username, email)
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