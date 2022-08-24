package com.user.handlers

import com.user.interfaces.Handler
import com.user.interfaces.IGetAllUsers
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.util.pipeline.*

class GetAllUsersHandler(private val getAllUsersUseCase : IGetAllUsers) : Handler {

    private val PATH = "/user"

    override fun routing(a: Application) {
        a.routing {
            route(PATH) {
                get { getAllUsers() }
            }
        }
    }

    suspend fun PipelineContext<Unit, ApplicationCall>.getAllUsers() {
        call.respond(getAllUsersUseCase())
    }
}