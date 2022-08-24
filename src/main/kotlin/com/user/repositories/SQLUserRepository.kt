package com.user.repositories

import com.user.interfaces.IUserRepository
import com.user.models.User

class SQLUserRepository() : IUserRepository  {
    override fun getUserByName(userName: String): User {
        TODO("Not yet implemented")
    }

    override fun getUsers(): List<User> {
        TODO("Not yet implemented")
    }

    override fun saveUser(user: User) {
        TODO("Not yet implemented")
    }

    override fun GenerateSaveFile() {
        TODO("Not yet implemented")
    }

    override fun getOpponentFor(challengerUser: String): User {
        TODO("Not yet implemented")
    }

    override fun addVictory(userName: String) {
        TODO("Not yet implemented")
    }
}