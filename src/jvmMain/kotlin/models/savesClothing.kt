package models

import models.savesOutfit.defaultExpression
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.CurrentDateTime
import org.jetbrains.exposed.sql.Table
import org.joda.time.DateTime

object savesClothing: Table() {
    val cid: Column<Int> = integer("cid").references(Clothing.cid).primaryKey()
    val userId: Column<Int> = integer("userid").references(Accounts.userId).primaryKey()
    val createdAt: Column<DateTime> = datetime("createdat").defaultExpression(CurrentDateTime())
}

data class ClothingBookmark(
        val cid: Int,
        val userId: Int,
        val createdAt: DateTime
)
