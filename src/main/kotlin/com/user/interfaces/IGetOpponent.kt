package com.user.interfaces

import com.user.models.User

interface IGetOpponent {
    operator fun invoke(challengerUser: String): User
}