package com.user.providers

import com.user.actions.AddVictoryUseCase
import com.user.actions.GetAllUsers
import com.user.actions.GetOpponentUseCase
import com.user.actions.LogInUseCase

object UseCaseProvider {
    val getOpponent by lazy {
        GetOpponentUseCase(RepositoryProvider.getUsersRepository)
    }

    val getLogIn by lazy {
        LogInUseCase(RepositoryProvider.getUsersRepository)
    }

    val addVictory by lazy {
        AddVictoryUseCase(RepositoryProvider.getUsersRepository)
    }

    val getAllUsers by lazy {
        GetAllUsers(RepositoryProvider.getUsersRepository)
    }
}