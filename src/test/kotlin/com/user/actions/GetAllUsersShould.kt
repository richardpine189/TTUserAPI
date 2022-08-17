package com.user.actions

import com.user.interfaces.IUserRepository
import com.user.models.User
import org.junit.Assert
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class GetAllUsersShould {

    @Test
    fun `callRepositoryGetUsers`(){

        // Arrange
        var userRepository : IUserRepository = mock()
        var getAllUsers = GetAllUsers(userRepository);

        // Act
        getAllUsers.invoke();

        // Assert
        verify(userRepository, times(1)).getUsers();
    }

    @Test
    fun `callRepositoryGetUsers_ReturnsUserList`(){

        // Arrange
        var userList : List<User> = listOf(
            User(1, "Theo", "theo@gmail.com"),
            User(2, "Ricardo", "Ricardo@hotmail.com")
        )

        var userRepository : IUserRepository = mock()
        whenever(userRepository.getUsers()).thenReturn(userList)
        var getAllUsers = GetAllUsers(userRepository)

        // Act
        var resultUsers = getAllUsers.invoke()

        // Assert
        Assert.assertEquals(resultUsers, userList)
    }
}