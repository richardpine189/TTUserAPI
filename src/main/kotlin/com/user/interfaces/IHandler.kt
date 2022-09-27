package com.user.interfaces

import io.ktor.server.application.*

interface IHandler {
    fun routing(a: Application)
}