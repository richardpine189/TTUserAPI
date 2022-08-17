package com.user

import com.user.actions.GetAllUsers
import com.user.interfaces.IUserRepository
import com.user.models.User
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

// Create repository (where should this be?)
//val userRepository : IUserRepository = JsonUserRepository("users.json");
val userRepository : IUserRepository = JsonUserRepository("testUsers.json");

fun Application.userRouting() {
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

            get("/getOpponent/{userName}")
            {
                val userName = call.parameters["userName"]?.toString()

                call.respond(users[1].name)
            }

            // Login by username
            post("/logIn") {
                val formParameters = call.receiveParameters()
                val username = formParameters["userName"].toString()

                val result = when(username)
                {
                    null -> call.respond(HttpStatusCode.BadRequest, "Must send a Username")
                    else -> {
                        val user = users.firstOrNull{it.name == username}
//                        Thread.sleep(2000)
                        when(user)
                        {
                            null -> call.respond(HttpStatusCode.NotFound, "User not found")
                            // Coin assignment is hardcoded here
                            else -> {
                                user.coin = (5..20).random()
                                call.respond(user)
                            }
                        }
                    }
                }
            }

            post {
                val candidate = call.receive<User>()

                users.add(candidate)
                call.respond(HttpStatusCode.Created)
            }

            put {
                val candidate = call.receive<User>()

                for(user in users)
                {
                    if(user.id == candidate.id)
                    {
                        users[users.indexOf(user)] = candidate
                        call.respond("Updated")
                    }
                }
            }

            delete("{id?}") {
                val id = call.parameters["id"] ?: return@delete call.respond(HttpStatusCode.BadRequest)
                if (users.removeIf { it.id == id.toLong() }) {
                    call.respondText("User removed correctly", status = HttpStatusCode.Accepted)
                } else {
                    call.respondText("Not Found", status = HttpStatusCode.NotFound)
                }
            }

            get("/victories/{id}"){
                val id = call.parameters["id"]?.toLongOrNull()

                call.respond(3)
            }
        }
    }
}