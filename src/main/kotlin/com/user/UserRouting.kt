package com.user

import com.user.db.DatabaseConnection
import com.user.entities.UserEntity
import com.user.models.User
import com.user.providers.GatewayConfig
import com.user.providers.HandlerProvider
import io.ktor.http.*
import io.ktor.network.sockets.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.ktorm.dsl.forEach
import org.ktorm.dsl.from
import org.ktorm.dsl.map
import org.ktorm.dsl.select
import java.sql.Connection
import java.sql.DriverManager
import java.util.function.LongToDoubleFunction


val users = mutableListOf(
    User(1, "Theo", "theo@gmail.com"),
    User(2, "Ricardo", "Ricardo@hotmail.com"),
    User(3, "Romina", "ro@mina.com")
)

fun Application.userRouting() {

    val getOpponentHandler = HandlerProvider.getOpponent
    getOpponentHandler.routing(this)

    val logInHandler = HandlerProvider.logIn
    logInHandler.routing(this)

    val addVictoryHandler = HandlerProvider.addVictory
    addVictoryHandler.routing(this)

    val getAllUsersHandler = HandlerProvider.getAllUsers
    getAllUsersHandler.routing(this)

    routing {
        route( "/user" ) {
            get("/{id}"){
                val id = call.parameters["id"]?.toLongOrNull()
                val result = when(id)
                {
                    null -> call.respond(HttpStatusCode.BadRequest, "ID must be long")
                    else -> {
                        val user = users.firstOrNull{it.id == id }
                        when(user)
                        {
                            null -> call.respond(HttpStatusCode.NotFound, "Not found at all")
                            else -> call.respond(user)
                        }
                    }
                }
            }
        }
    }
}