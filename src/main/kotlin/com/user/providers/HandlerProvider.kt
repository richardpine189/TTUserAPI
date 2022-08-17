package com.user.providers

import com.user.handlers.AddVictoryHandler
import com.user.handlers.GetOpponentHandler
import com.user.handlers.LoginHandler

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
}