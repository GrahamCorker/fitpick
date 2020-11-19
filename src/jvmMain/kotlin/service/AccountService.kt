package service

import models.Accounts
import Account
import DatabaseFactory.dbQuery
import org.jetbrains.exposed.sql.*


class AccountService {

    //Converts result rows returned by the query into the Account data class
    private fun toAccount(row: ResultRow): Account =
            Account(
                    userId = row[Accounts.userId],
                    gender = row[Accounts.gender],
                    zipcode = row[Accounts.zipcode],
                    username = row[Accounts.username],
                    email = row[Accounts.email],
                    password = row[Accounts.password]
            )

    suspend fun getAllAccounts(): List<Account> = dbQuery {
        Accounts.selectAll().map{toAccount(it)}
    }

    suspend fun getAccountByEmail(email: String): Account? = dbQuery {
        Accounts.select{
            (Accounts.email eq email)
        }.mapNotNull { toAccount(it) }.singleOrNull()
    }

    //Use BCrypt to encrypt passwords?
    suspend fun createAccount(account: Account) = dbQuery {
        Accounts.insert{
            it[Accounts.gender] = account.gender;
            it[Accounts.email] = account.email;
            it[Accounts.password] = account.password;
            it[Accounts.username] = account.username;
            it[Accounts.zipcode] = account.zipcode;
        }
    }

    suspend fun getAccountById(id: Int): Account? = dbQuery {
        Accounts.select{
            (Accounts.userId eq id)
        }.mapNotNull {toAccount(it)}.singleOrNull()
    }

    suspend fun updateAccount(account: Account) = dbQuery {
        Accounts.update ({ Accounts.userId eq account.userId}){
            it[Accounts.gender] = account.gender;
            it[Accounts.email] = account.email;
            it[Accounts.password] = account.password;
            it[Accounts.username] = account.username;
            it[Accounts.zipcode] = account.zipcode;
        }
    }



}