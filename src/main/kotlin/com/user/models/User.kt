package com.user.models
import kotlinx.serialization.Serializable

@Serializable
data class User(val id: Long, var name: String, var email: String, var coin : Int = 0, var victories : Int = 0) { }
