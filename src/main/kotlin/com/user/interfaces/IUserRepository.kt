package com.user.interfaces

import com.user.models.User

interface IUserRepository {

    fun getUserByName(userName: String): User

    fun getUsers(): List<User>

    fun addVictory(userId : Int)

    fun saveUsers()

    fun getOpponentFor(challengerUser: String): User
}
