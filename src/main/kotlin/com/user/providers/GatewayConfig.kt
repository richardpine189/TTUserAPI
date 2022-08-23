package com.user.providers

import io.ktor.server.util.*
import org.ktorm.database.Database
object GatewayConfig {
    val getUsersFilePath by lazy {
        "src/main/kotlin/com/user/User.json"
    }

    val getTestUsersFilePath by lazy {
        "src/test/kotlin/com/user/repositories/testUsers.json"
    }
}
