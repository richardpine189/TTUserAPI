package com.user.interfaces

import com.user.models.User

interface IUserRepository {

    fun getUserByName(userName: String): User

    fun getUsers(): List<User>

    fun saveUser(user: User)

    fun getOpponentFor(challengerUser: String): User
}
