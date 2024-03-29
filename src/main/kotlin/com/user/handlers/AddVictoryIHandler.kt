package com.user.handlers
import com.user.interfaces.IHandler
import com.user.interfaces.IAddVictory
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.util.pipeline.*

class AddVictoryIHandler(private val addVictoryUseCase : IAddVictory) : IHandler {

    private val PATH = "/addVictory"

    override fun routing(a: Application) {
        a.routing {
            route(PATH) {
                patch { addVictory() }
            }
        }
    }

    suspend fun PipelineContext<Unit, ApplicationCall>.addVictory() {
        val userName = call.receiveText()
        println(userName)


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