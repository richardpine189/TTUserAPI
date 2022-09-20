package com.user.providers

import com.user.handlers.*

object HandlerProvider {
    val getOpponent by lazy {
        GetOpponentHandler(UseCaseProvider.getOpponent)
    }

    val logIn by lazy {
        LoginHandler(UseCaseProvider.getLogIn)
    }

    val addVictory by lazy {
        AddVictoryHandler(UseCaseProvider.addVictory)
    }

    val getAllUsers by lazy {
        GetAllUsersHandler(UseCaseProvider.getAllUsers)
    }

    val createUser by lazy {
        CreateUserHandler(UseCaseProvider.createUser)
    }
}