package com.user.interfaces

import com.user.models.User

interface IGetAllUsers {
    operator fun invoke() : List<User>
}
