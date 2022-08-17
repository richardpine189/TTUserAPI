package com.user.models
import com.user.Exceptions.NotEnoughCoinException
import com.user.models.*
import org.junit.Assert
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.BeforeAll
import kotlin.test.assertEquals


class UserShould {
    private val userName = "Theo"
    private val email = "newEmail@gmail.com"
    private val initialCoins = 10
    private var user = User(0, userName, email)

    @BeforeAll
    fun setUp(){
        user.AddCoin(initialCoins)
    }

    @Test
    fun `return User name`()
    {
        Assert.assertEquals(user.name, userName)
    }

    @Test
    fun `return Email`()
    {
        Assert.assertEquals(user.email, email)
    }

    @Test
    fun `return Current Coin Amount`()
    {
        Assert.assertEquals(user.coin, initialCoins)
    }

    @Test
    fun `Change Name`()
    {
        val newName= "Ricardo"
        user.ChangeName(newName)
        Assert.assertEquals(user.name, newName)
    }

    @Test
    fun `Subtract coin from wallet`()
    {
        val coinToSubtract = 10
        val currentCoin = user.coin
        user.SubtractCoin(coinToSubtract)
        Assert.assertEquals(user.coin, currentCoin - coinToSubtract)
    }

    @Test
    fun `Coin is never below zero`()
    {
        val currentCoin = user.coin
        user.SubtractCoin(coinToSubtract = 20)

        Assert.assertEquals(user.coin, currentCoin)
    }

    @Test
    fun `Throw Exception when try to subtract below zero`()
    {
        val coinToSubtract = 20

        assertThrows(NotEnoughCoinException::class.java) {
            user.SubtractCoin(coinToSubtract)
        }
    }

    @Test
    fun `Add Coin to wallet`()
    {
        val coinToAdd = 10
        val currentCoin = user.coin
        user.AddCoin(coinToAdd)
        Assert.assertEquals(user.coin, currentCoin + coinToAdd)
    }

//    @ParameterizedTest
//    @ValueSource(ints = [50, 51, 52, 53, 54, 55])
//    fun `Return The Prison Wait until someone comes to release you - they then take your place rule for spaces 50 to 55`(space: Int){
//
//        val result = board.returnRule(space)
//
//        assertEquals("The Prison: Wait until someone comes to release you - they then take your place", result)
//    }
}