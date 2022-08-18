package com.user

import com.user.actions.GetAllUsers
import com.user.actions.GetOpponentUseCase
import com.user.handlers.GetOpponentHandler
import com.user.handlers.LoginHandler
import com.user.interfaces.IUserRepository
import com.user.models.User
import com.user.providers.HandlerProvider
import com.user.repositories.JsonUserRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

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

    routing {
        route( "/user" ) {
            get {
//                userRepository.saveUsers()
//                val action : GetAllUsers = GetAllUsers(userRepository)
//                var jsonUsers = action.invoke();
//
//                call.respond(jsonUsers)
                call.respond(users)
            }

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