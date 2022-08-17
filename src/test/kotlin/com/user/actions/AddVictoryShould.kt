package com.user.actions

import com.user.interfaces.IUserRepository
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify

class AddVictoryShould {
    @Test
    fun `Victory is added when requested`()
    {
        // Arrange
        val userName = "Romina"
        val userRepository : IUserRepository = mock()
        val addVictory = AddVictoryUseCase(userRepository)

        // Act
        addVictory(userName)

        // Assert
        verify(userRepository, times(1)).addVictory(userName)
    }
}