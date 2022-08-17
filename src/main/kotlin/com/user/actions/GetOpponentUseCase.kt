package com.user.actions

import com.user.interfaces.IGetOpponent
import com.user.interfaces.IUserRepository
import com.user.models.User

class GetOpponentUseCase(val usersRepository : IUserRepository) : IGetOpponent{
    override fun invoke(challengerUser: String): User {
        return usersRepository.getOpponentFor(challengerUser)
    }
}