package com.user.actions

import com.user.interfaces.IUserRepository

class UserVictories(val userRepository: IUserRepository) {
    fun getVictories(userId: Int): Int {
        TODO()
    }

    fun addVictory(userId: Int) {
        userRepository.addVictory(userId)
    }
}