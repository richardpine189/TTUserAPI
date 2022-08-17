package com.user.models

import com.user.Exceptions.NotEnoughCoinException
import kotlinx.serialization.Serializable

@Serializable
data class User(val id: Long, var name: String, var email: String)
{
    var coin = 0
    var victories = 2
}
