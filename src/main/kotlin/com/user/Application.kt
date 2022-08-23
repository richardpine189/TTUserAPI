package com.user


import com.team8.plugins.configureSerialization
import com.user.handlers.GetOpponentHandler
import com.user.interfaces.IGetOpponent
import com.user.models.User
import io.ktor.server.application.*
import com.user.plugins.*
import com.user.providers.GatewayConfig
import java.io.File

fun main(args: Array<String>): Unit =
        io.ktor.server.netty.EngineMain.main(args)

//@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    configureRouting()
    configureSerialization()
    userRouting()

}