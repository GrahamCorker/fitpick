package models

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.CurrentDateTime
import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.Table
import org.joda.time.DateTime

object savesOutfit: Table() {
    val outfitID: Column<Int> = integer("outfitid").references(Outfit.outfitID, onDelete = ReferenceOption.CASCADE).primaryKey()
    val userId: Column<Int> = integer("userid").references(Accounts.userId).primaryKey()
    val createdAt: Column<DateTime> = datetime("createdat").defaultExpression(CurrentDateTime())
}


data class OutfitBookmark(
        val outfitID: Int,
        val userId: Int,
        val createdAt: DateTime
)


