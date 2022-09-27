package com.user.handlers

import com.user.interfaces.IHandler
import com.user.interfaces.IGetOpponent
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.util.pipeline.*

class GetOpponentIHandler(private val getOpponentUseCase: IGetOpponent) : IHandler {

    private val PATH = "/getOpponent/{userName}"

    override fun routing(a: Application) {
        a.routing {
            route(PATH) {
                get { getOpponent() }
            }
        }
    }

    suspend fun PipelineContext<Unit, ApplicationCall>.getOpponent() {
        val challengerUser = context.parameters["userName"]
        val opponent = getOpponentUseCase(challengerUser!!)
        println(opponent.name)
        call.respond(opponent.name)
        call.respond(HttpStatusCode.OK)
    }
}