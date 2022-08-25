package com.user.providers

import com.user.providers.db.DatabaseConnectionProvider
import com.user.repositories.JsonUserRepository
import com.user.repositories.SQLUserRepository

object RepositoryProvider {
//    val getUsersRepository by lazy {
//        JsonUserRepository(GatewayConfig.getUsersFilePath)
//    }

    val getUsersRepository by lazy {
        SQLUserRepository(GatewayConfig.getDatabaseConection)
    }
}