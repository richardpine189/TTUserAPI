package com.user.providers

import com.user.actions.GetOpponentUseCase

object UseCaseProvider {
    val getOpponent by lazy {
        GetOpponentUseCase(RepositoryProvider.getUsersRepository)
    }
}