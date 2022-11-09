package com.user.handlers

import com.user.Exceptions.UserNotFoundException
import com.user.interfaces.IHandler
import com.user.interfaces.IGetOpponent
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.util.pipeline.*

class GetOpponentHandler(private val getOpponentUseCase: IGetOpponent) : IHandler {

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

        try {
            val opponent = getOpponentUseCase(challengerUser!!)
            //call.respond(HttpStatusCode.OK)
            call.respond(opponent.name)
        }
        catch (ex: UserNotFoundException)
        {
            call.respond(HttpStatusCode.NoContent, ex.message.toString())
        }
    }
}