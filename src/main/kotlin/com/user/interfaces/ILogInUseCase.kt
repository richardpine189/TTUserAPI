package com.user.interfaces

import com.user.models.User

interface ILogInUseCase {
    operator fun invoke(userName : String) : User
}