package com.user.actions

import com.user.interfaces.IUserRepository
import com.user.models.User
import org.junit.Test
import kotlin.test.assertEquals
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class GetOpponentShould {
    @Test
    fun `return opponent when is called`()
    {
        // Arrange
        val challengerUser = "Theo"
        val expectedUser = User(2, "Ricardo", "ric@rdo.com")
        val repository : IUserRepository = mock()
        whenever(repository.getOpponentFor(challengerUser)).thenReturn(expectedUser)
        val GetOpponent = GetOpponentUseCase(repository)

        // Act
        val resultUser = GetOpponent(challengerUser)

        // Assert
        assertEquals(expectedUser, resultUser)
    }
}