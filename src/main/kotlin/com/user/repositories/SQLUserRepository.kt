package com.user.repositories

import com.user.entities.UserEntity
import com.user.interfaces.IUserRepository
import com.user.models.User
import io.ktor.network.sockets.*
import io.ktor.server.plugins.*
import org.ktorm.database.Database
import org.ktorm.dsl.*
import org.ktorm.expression.ColumnExpression
import org.ktorm.expression.OrderByExpression
import org.ktorm.expression.OrderType
import java.util.Random

class SQLUserRepository(private val db : Database) : IUserRepository  {
    override fun getUserByName(userName: String): User {
        val users = db.from(UserEntity).select()
            .where{ UserEntity.name eq userName }
            .map{
                val id = it[UserEntity.id]!!.toLong()
                val name = it[UserEntity.name]!!
                val email = it[UserEntity.email]!!
                val coin = it[UserEntity.coin]!!.toInt()
                val victories = it[UserEntity.victories]!!.toInt()
                User(id,name,email, coin, victories)
            }

        if(users.isEmpty())
        {
            throw NotFoundException("User not found.")
        }

        return users.first()
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
        val users = db.from(UserEntity).select()
            .where{ UserEntity.name notEq challengerUser }
            .map{
                val id = it[UserEntity.id]!!.toLong()
                val name = it[UserEntity.name]!!
                val email = it[UserEntity.email]!!
                val coin = it[UserEntity.coin]!!.toInt()
                val victories = it[UserEntity.victories]!!.toInt()
                User(id,name,email, coin, victories)
            }

        return users.random();
    }

    override fun createUser(userName: String, email: String): User {
        db.insertAndGenerateKey(UserEntity){
            set(it.name, userName)
            set(it.email, email)
            set(it.coin, 0)
            set(it.victories, 0)
        }

        return getUserByName(userName)
    }
}