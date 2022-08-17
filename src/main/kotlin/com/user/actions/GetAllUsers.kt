package com.user.actions

import com.user.interfaces.IUserRepository
import com.user.models.User

class GetAllUsers(val repository: IUserRepository) {

    fun invoke() : List<User> {
        return repository.getUsers();
    }
}
