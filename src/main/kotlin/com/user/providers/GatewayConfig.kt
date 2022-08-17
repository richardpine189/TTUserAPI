package com.user.providers

object GatewayConfig {
    val getUsersFilePath by lazy {
        "src/main/kotlin/com/user/User.json"
    }

    val getTestUsersFilePath by lazy {
        "src/test/kotlin/com/user/repositories/testUsers.json"
    }
}