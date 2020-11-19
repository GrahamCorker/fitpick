package models

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.Table

object Outfit: Table() {
    val outfitID: Column<Int> = integer("outfitid").autoIncrement().primaryKey()
    val headWear: Column<Int> = integer("headwear").references(Clothing.cid, ReferenceOption.CASCADE)
    val lowerSection: Column<Int> = integer("lowersection").references(Clothing.cid, ReferenceOption.CASCADE)
    val midSection: Column<Int> = integer("midsection").references(Clothing.cid, ReferenceOption.CASCADE)
    val footWear: Column<Int> = integer("footwear").references(Clothing.cid, ReferenceOption.CASCADE)
    val accessory: Column<Int> = integer("accessory").references(Clothing.cid, ReferenceOption.CASCADE)
}

data class OutfitObj(
    val outfitId: Int,
    val headWear: Int,
    val lowerSection: Int,
    val midSection: Int,
    val footWear: Int,
    val accessory: Int
)