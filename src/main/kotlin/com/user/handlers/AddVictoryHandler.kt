package com.user.handlers
import com.user.interfaces.Handler
import com.user.interfaces.IAddVictory
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.util.pipeline.*

class AddVictoryHandler(private val addVictoryUseCase : IAddVictory) : Handler {

    private val PATH = "/addVictory"

    override fun routing(a: Application) {
        a.routing {
            route(PATH) {
                patch { addVictory() }
            }
        }
    }

    suspend fun PipelineContext<Unit, ApplicationCall>.addVictory() {
        val formParameters = call.receiveParameters()
        val userName = formParameters["userName"].toString()

        if(addVictoryUseCase(userName))
        {
            call.respond(HttpStatusCode.OK)
        }
        else
        {
            call.respond(HttpStatusCode.NotFound, "User not found.")
        }
    }
}