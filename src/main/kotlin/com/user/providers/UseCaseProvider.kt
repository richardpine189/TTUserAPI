package com.user.providers

import com.user.actions.*

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

    val createUser by lazy {
        CreateUserUseCase(RepositoryProvider.getUsersRepository)
    }
}