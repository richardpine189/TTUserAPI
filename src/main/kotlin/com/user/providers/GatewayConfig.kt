package com.user.providers

import com.user.providers.db.DatabaseConnectionProvider

object GatewayConfig {
    val getUsersFilePath by lazy {
        "src/main/kotlin/com/user/User.json"
    }

    val getTestUsersFilePath by lazy {
        "src/test/kotlin/com/user/repositories/testUsers.json"
    }

    val getDatabaseConection by lazy {
        DatabaseConnectionProvider.localDatabase
    }
}
