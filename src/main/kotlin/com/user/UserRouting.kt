package com.user

import com.user.providers.HandlerProvider
import io.ktor.server.application.*


fun Application.userRouting() {

    val getOpponentHandler = HandlerProvider.getOpponent
    getOpponentHandler.routing(this)

    val logInHandler = HandlerProvider.logIn
    logInHandler.routing(this)

    val addVictoryHandler = HandlerProvider.addVictory
    addVictoryHandler.routing(this)

    val getAllUsersHandler = HandlerProvider.getAllUsers
    getAllUsersHandler.routing(this)

    val createUserHandler = HandlerProvider.createUser
    createUserHandler.routing(this)

    val remoteConfigurationHandler = HandlerProvider.remoteConfig
    remoteConfigurationHandler.routing(this)

}