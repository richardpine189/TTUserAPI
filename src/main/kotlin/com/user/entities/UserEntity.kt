package com.user.entities

import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object UserEntity: Table<Nothing>("user") {
    val id = int("id").primaryKey()
    val name = varchar("name")
    val email = varchar("email")
    val coin = int("coin")
    val victories = int("victories")
}