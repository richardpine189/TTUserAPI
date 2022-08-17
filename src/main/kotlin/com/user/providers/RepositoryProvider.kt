package com.user.providers

import com.user.repositories.JsonUserRepository

object RepositoryProvider {
    val getUsersRepository by lazy {
        JsonUserRepository(GatewayConfig.getUsersFilePath)
    }
}