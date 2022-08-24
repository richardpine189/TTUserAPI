package com.user.repositories

import com.user.interfaces.IUserRepository
import com.user.models.User
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

class JsonUserRepository(val path : String) : IUserRepository{
    override fun getUserByName(userName: String): User {
        val users = getUsers()

        return users.first{ it.name == userName }
    }

    override fun getUsers(): List<User> {
        return Json.decodeFromString<List<User>>(File(path).readText(Charsets.UTF_8))
    }

    override fun saveUser(user: User) {
        val userList : MutableList<User> = getUsers().toMutableList()
        userList.removeIf{ it.name == user.name}
        userList.add(user)
        val formatter = Json { encodeDefaults = true }
        val json = formatter.encodeToString(userList)
        File(path).writeText(json)
    }

    override fun GenerateSaveFile() {
        val userList : List<User> = listOf(
            User(1, "Theo", "theo@gmail.com"),
            User(2, "Ricardo", "Ricardo@hotmail.com")
        )

        val path = "testUsers.json"

        val formatter = Json { encodeDefaults = true }

        val json = formatter.encodeToString(userList)

        File(path).writeText(json)
    }

    override fun getOpponentFor(challengerUser: String): User {
        val users = getUsers()

        return users.first{ it.name != challengerUser }
    }

//    override fun addVictory(userName: String) {
//        val user = getUserByName(userName)
//        user.victories++
//        user.coin += 100 // MAGIC NUMBER
//        saveUser(user)
//    }
}
