package com.user.handlers

import com.user.interfaces.IHandler
import com.user.interfaces.IGetAllUsers
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.util.pipeline.*

class GetAllUsersIHandler(private val getAllUsersUseCase : IGetAllUsers) : IHandler {

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