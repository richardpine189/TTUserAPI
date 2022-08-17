package com.user.handlers

import com.user.interfaces.Handler
import com.user.interfaces.IGetOpponent
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.util.pipeline.*
import kotlin.text.get

class GetOpponentHandler(private val getOpponentUseCase: IGetOpponent) : Handler {
    override fun routing(a: Application) {
        a.routing {
            route("/getOpponent/{userName}"){
                get { getOpponent() }
            }
        }
    }

    suspend fun PipelineContext<Unit, ApplicationCall>.getOpponent() {
        val challengerUser = context.parameters["userName"]
        val opponent = getOpponentUseCase(challengerUser!!)
        call.respond(opponent)
        call.respond(HttpStatusCode.OK)
    }
}