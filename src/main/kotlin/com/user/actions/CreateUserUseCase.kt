package com.user.actions

import com.user.interfaces.ICreateUseCase
import com.user.interfaces.IUserRepository
import com.user.models.User

class CreateUserUseCase(val userRepository: IUserRepository) : ICreateUseCase {
    override fun invoke(userName: String, email: String): User {
        return userRepository.createUser(userName, email)
    }

}