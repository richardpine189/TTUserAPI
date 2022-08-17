package com.user.actions

import com.user.interfaces.IUserRepository
import com.user.models.User
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import kotlin.test.assertEquals

class UserVictoriesShould {

    @Test
    fun `Add Victory to User`()
    {
        // Arrange
        val userId = 99
        val userRepository = mock<IUserRepository>()
        val userVictories = UserVictories(userRepository)

        // Act
        userVictories.addVictory(userId)

        // Assert
        verify(userRepository, times(1)).addVictory(userId)
    }

//    @Test
//    fun `Get Number of Victories`()
//    {
//        // Arrange
//        val userId = 99
//        val expectedVictories = 7
//        val user = User(99, "test", "test@test.com")
//
//        val userRepository = mock<IUserRepository>()
//        whenever(userRepository.getUser(userId)).thenReturn(expectedVictories)
//        val getUserVictories = UserVictories(userRepository)
//
//        // Act
//        val userVictories = getUserVictories.getVictories(userId)
//
//        // Assert
//        assertEquals(expectedVictories, userVictories)
//    }
}