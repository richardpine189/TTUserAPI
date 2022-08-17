package com.user.repositories

import com.user.interfaces.IUserRepository
import com.user.models.User
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

class JsonUserRepository(val path : String) : IUserRepository{
    override fun getUsers(): List<User> {
        return Json.decodeFromString<List<User>>(File(path).readText(Charsets.UTF_8))
    }

    override fun addVictory(userId: Int) {
        TODO("Not yet implemented")
    }

    override fun saveUsers() {
        val userList : List<User> = listOf(
            User(1, "Theo", "theo@gmail.com"),
            User(2, "Ricardo", "Ricardo@hotmail.com")
        )
        val path = "testUsers2.json"

        val json = Json.encodeToString(userList)

        File(path).writeText(json)
    }

    override fun getOpponentFor(challengerUser: String): User {
        val users = getUsers()

        val challenger = users.first{ it.name == challengerUser }

        return users.first{ it.name != challengerUser }
    }
}
