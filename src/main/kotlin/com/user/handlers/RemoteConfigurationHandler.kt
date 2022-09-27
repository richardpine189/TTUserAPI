package com.user.handlers

import com.user.interfaces.IHandler
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.util.pipeline.*
import kotlinx.serialization.Serializable

@Serializable
data class RemoteConfiguration(var reMatchIsActive : Boolean, var reSpinLetterIsActive : Boolean, var reLoadSingleCategoryIsActive: Boolean, var recommendWordIsActive : Boolean)

class RemoteConfigurationHandler : IHandler {
    val remoteConfig = RemoteConfiguration(false,false,false,false)
    val PATH = "/remoteConfig"
    override fun routing(a: Application) {
        a.routing {
            route(PATH){
                post { setRemoteConfig() }
                get{ getRemoteConfig() }
            }
        }
    }

    suspend fun PipelineContext<Unit, ApplicationCall>.setRemoteConfig() {
        val formParameters = call.receiveParameters()
        val reMatch = formParameters["reMatchIsActive"].toBoolean()
        val reSpin = formParameters["reSpinLetterIsActive"].toBoolean()
        val reLoadSingleCategory = formParameters["reLoadSingleCategoryIsActive"].toBoolean()
        val recommendWord = formParameters["recommendWordIsActive"].toBoolean()

        remoteConfig.reMatchIsActive = reMatch
        remoteConfig.reSpinLetterIsActive = reSpin
        remoteConfig.reLoadSingleCategoryIsActive = reLoadSingleCategory
        remoteConfig.recommendWordIsActive = recommendWord

        call.respond(HttpStatusCode.OK)
    }

    suspend fun PipelineContext<Unit, ApplicationCall>.getRemoteConfig(){

        call.respond(remoteConfig)
    }
}