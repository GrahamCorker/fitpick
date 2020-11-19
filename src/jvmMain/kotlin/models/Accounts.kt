package models

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table



object Accounts: Table() {
    val userId: Column<Int> = integer("userid").autoIncrement().primaryKey()
    val gender: Column<String> = varchar("gender", 15)
    val zipcode: Column<Int> = integer("zipcode")
    val username: Column<String> = varchar("username", 50)
    val email: Column<String> = varchar("email", 255)
    val password: Column<String> = varchar("password", 100)
}




