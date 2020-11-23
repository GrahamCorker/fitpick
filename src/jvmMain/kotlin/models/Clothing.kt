package models

import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table
import java.math.BigDecimal

//TODO: Make itemType an ENUM
object Clothing: Table() {
    val cid: Column<Int> = integer("cid").autoIncrement().primaryKey()
    val price: Column<BigDecimal> = decimal("price", 15, 6)
    val siteLink: Column<String> = text("sitelink", null)
    val isAdult: Column<Boolean> = bool("isadult")
    val genderPref: Column<String> = varchar("genderpref", 15)
    val title: Column<String> = text("title", null)
    val img: Column<String> = text("img", null)
    //Making the itemType a string for now. Queries will work the exact same way
    val itemType: Column<String> = varchar("itemtype", 20)
}
