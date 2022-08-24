package com.user.actions

import com.user.interfaces.IAddVictory
import com.user.interfaces.IUserRepository

class AddVictoryUseCase(val userRepository: IUserRepository) : IAddVictory {

    override fun invoke(userName: String): Boolean {
        try {
            var user = userRepository.getUserByName(userName)

            user.victories += 1
            user.coin += 100

            userRepository.saveUser(user)
        }
        catch (e : Exception) {
            return false
        }
        return true
    }
}