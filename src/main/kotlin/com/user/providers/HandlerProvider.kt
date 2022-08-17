package com.user.providers

import com.user.handlers.GetOpponentHandler

object HandlerProvider {
    val getOpponent by lazy {
        GetOpponentHandler(UseCaseProvider.getOpponent)
    }
}