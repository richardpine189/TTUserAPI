package com.user.interfaces

import com.user.models.User

interface ICreateUseCase {
    operator fun invoke(newUser: String, email: String): User
}