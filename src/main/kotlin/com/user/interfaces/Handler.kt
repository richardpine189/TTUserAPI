package com.user.interfaces

import io.ktor.server.application.*

interface Handler {
    fun routing(a: Application)
}