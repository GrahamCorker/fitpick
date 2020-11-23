package service

import models.Accounts
import Account
import DatabaseFactory.dbQuery
import Signup
import models.FullAccount
import org.jetbrains.exposed.sql.*


class AccountService {

    //Converts result rows returned by the query into the Account data class
    private fun toFullAccount(row: ResultRow): FullAccount =
            FullAccount(
                    userId = row[Accounts.userId],
                    gender = row[Accounts.gender],
                    zipcode = row[Accounts.zipcode],
                    username = row[Accounts.username],
                    email = row[Accounts.email],
                    password = row[Accounts.password]
            )

    fun toSerializableAccount(account: FullAccount) : Account =
        Account(
            userId = account.userId,
            gender = account.gender,
            zipcode = account.zipcode,
            username = account.username,
            email = account.email
        )

    suspend fun getAllAccounts(): List<FullAccount> = dbQuery {
        Accounts.selectAll().map{toFullAccount(it)}
    }

    suspend fun getAccountByEmail(email: String): FullAccount? = dbQuery {
        Accounts.select{
            (Accounts.email eq email)
        }.mapNotNull { toFullAccount(it) }.singleOrNull()
    }

    //Use BCrypt to encrypt passwords?
    suspend fun createAccount(account: Signup) = dbQuery {
        val acc = Accounts.insert{
            it[Accounts.gender] = account.gender;
            it[Accounts.email] = account.email;
            it[Accounts.password] = account.password;
            it[Accounts.username] = account.username;
            it[Accounts.zipcode] = account.zipcode;
        }
    }

    suspend fun getAccountById(id: Int): FullAccount? = dbQuery {
        Accounts.select{
            (Accounts.userId eq id)
        }.mapNotNull {toFullAccount(it)}.singleOrNull()
    }

    suspend fun updateAccount(account: FullAccount) = dbQuery {
        Accounts.update ({ Accounts.userId eq account.userId}){
            it[Accounts.gender] = account.gender;
            it[Accounts.email] = account.email;
            it[Accounts.password] = account.password;
            it[Accounts.username] = account.username;
            it[Accounts.zipcode] = account.zipcode;
        }
    }
}