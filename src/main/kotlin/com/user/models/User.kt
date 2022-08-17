package com.user.models

import com.user.Exceptions.NotEnoughCoinException
import kotlinx.serialization.Serializable

@Serializable
data class User(val id: Long, var name: String, var email: String)
{
    var coin = 0

    fun ChangeName(newName:String)
    {
        name = newName
    }

    fun SubtractCoin(coinToSubtract: Int) {

        if(coinToSubtract > coin)
        {
            throw NotEnoughCoinException("No hay plata")
        }
        coin -= coinToSubtract
    }

    fun AddCoin(coinToAdd: Int) {
        coin += coinToAdd
    }
}
