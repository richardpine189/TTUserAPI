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
        AddVictoryIHandler(UseCaseProvider.addVictory)
    }

    val getAllUsers by lazy {
        GetAllUsersIHandler(UseCaseProvider.getAllUsers)
    }

    val createUser by lazy {
        CreateUserIHandler(UseCaseProvider.createUser)
    }

    val remoteConfig by lazy{
        RemoteConfigurationHandler()
    }
}