package com.user.actions

import com.user.interfaces.IAddVictory
import com.user.interfaces.IUserRepository

class AddVictoryUseCase(val userRepository: IUserRepository) : IAddVictory {

    override fun invoke(userName: String): Boolean {
        try {
            userRepository.addVictory(userName)
        }
        catch (e : Exception) {
            return false
        }
        return true
    }
}