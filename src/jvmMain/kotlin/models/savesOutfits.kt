package models

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table
import org.joda.time.DateTime

object savesOutfits: Table() {
    val outfitID: Column<Int> = integer("outfitid").references(Outfit.outfitID).primaryKey()
    val userId: Column<Int> = integer("userid").references(Accounts.userId).primaryKey()
    val createdAt: Column<DateTime> = datetime("createdat")
}


data class OutfitBookmark(
        val outfitID: Int,
        val userId: Int,
        val createdAt: DateTime
)


