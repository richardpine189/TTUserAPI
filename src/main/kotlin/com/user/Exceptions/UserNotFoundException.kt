package com.user.Exceptions

class UserNotFoundException(id : Long) : RuntimeException("No se encontró el usuario solicitado (id = $id") {
}