package com.user.repositories

import com.user.entities.UserEntity
import com.user.interfaces.IUserRepository
import com.user.models.User
import io.ktor.network.sockets.*
import org.ktorm.database.Database
import org.ktorm.dsl.*
import org.ktorm.expression.ColumnExpression
import org.ktorm.expression.OrderByExpression
import org.ktorm.expression.OrderType

class SQLUserRepository(private val db : Database) : IUserRepository  {
    override fun getUserByName(userName: String): User {
        val user = db.from(UserEntity).select()
            .where{ UserEntity.name eq userName }
            .map{
                val id = it[UserEntity.id]!!.toLong()
                val name = it[UserEntity.name]!!
                val email = it[UserEntity.email]!!
                val coin = it[UserEntity.coin]!!.toInt()
                val victories = it[UserEntity.victories]!!.toInt()
                User(id,name,email, coin, victories)
            }
            .first()

        return user
    }

    override fun getUsers(): List<User> {
        val userList = db.from(UserEntity).select().map{
            val id = it[UserEntity.id]!!.toLong()
            val name = it[UserEntity.name]!!
            val email = it[UserEntity.email]!!
            val coin = it[UserEntity.coin]!!.toInt()
            val victories = it[UserEntity.victories]!!.toInt()
            User(id,name,email, coin, victories)
        }

        return userList
    }

    override fun saveUser(user: User) {
        db.update(UserEntity) {
            set(it.coin, user.coin)
            set(it.victories, user.victories)
                where { it.name eq user.name }
        }

    }

    override fun getOpponentFor(challengerUser: String): User {
        return db.from(UserEntity).select()
            .where { UserEntity.name notEq challengerUser }
            .map{
                val id = it[UserEntity.id]!!.toLong()
                val name = it[UserEntity.name]!!
                val email = it[UserEntity.email]!!
                val coin = it[UserEntity.coin]!!.toInt()
                val victories = it[UserEntity.victories]!!.toInt()
                User(id,name,email, coin, victories)
            }
            .first()
    }
}