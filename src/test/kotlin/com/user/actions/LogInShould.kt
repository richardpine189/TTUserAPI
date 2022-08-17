package com.user.actions

import com.user.interfaces.IUserRepository
import com.user.models.User
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import kotlin.test.assertEquals

class LogInShould {
    @Test
    fun `return user when when userName is provided`()
    {
        // Arrange
        val userName = "Test"
        val expectedUser = User(5, userName, "test@Test.com")
        val userRepository : IUserRepository = mock()
        whenever(userRepository.getUserByName(userName)).thenReturn(expectedUser)
        val LogIn = LogInUseCase(userRepository)

        // Act
        val resultUser = LogIn(userName)

        // Assert
        assertEquals(expectedUser, resultUser)
    }
}