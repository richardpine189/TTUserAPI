package com.user.interfaces

import com.user.models.User

interface IUserRepository {

    fun getUsers(): List<User>

    fun addVictory(userId : Int)

    fun saveUsers()
    fun getOpponentFor(challengerUser: String): User
}
