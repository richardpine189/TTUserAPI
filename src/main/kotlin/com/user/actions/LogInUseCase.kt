package com.user.actions

import com.user.interfaces.ILogInUseCase
import com.user.interfaces.IUserRepository
import com.user.models.User

class LogInUseCase(val userRepository: IUserRepository) : ILogInUseCase{
    override fun invoke(userName: String): User {
        return userRepository.getUserByName(userName)
    }

}