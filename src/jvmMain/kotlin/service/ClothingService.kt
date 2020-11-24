package service

import models.Clothing
import ClothingItem
import DatabaseFactory.dbQuery
import org.jetbrains.exposed.sql.*

class ClothingService {

    private fun toClothingItem(row: ResultRow): ClothingItem =
            ClothingItem(
                    cid = row[Clothing.cid],
                    price = row[Clothing.price].toDouble(),
                    siteLink = row[Clothing.siteLink],
                    isAdult = row[Clothing.isAdult],
                    genderPref = row[Clothing.genderPref],
                    title = row[Clothing.title],
                    img = row[Clothing.img],
                    itemType = row[Clothing.itemType]
            )

    private fun toCid(row:ResultRow): Int =
        row[Clothing.cid]


    //SELECT * FROM clothing;
    suspend fun getAllClothingItems(): List<ClothingItem> = dbQuery {
        Clothing.selectAll().map{toClothingItem(it)}
    }

    //SELECT * FROM clothing WHERE clothing.cid = id;
    suspend fun getClothingItemById(id: Int) : ClothingItem? = dbQuery {
        Clothing.select{
            (Clothing.cid eq id)
        }.mapNotNull { toClothingItem(it) }.singleOrNull()
    }

    suspend fun getClothingItemByType(itemType: String, cid: Int): ClothingItem? = dbQuery {
        Clothing.select{
            (Clothing.cid eq cid and (Clothing.itemType eq itemType))
        }.mapNotNull { toClothingItem(it) }.singleOrNull()
    }

    //TODO: add optional params isadult, price, and gender
    suspend fun getRandomClothingItem(type: String) : Int? = dbQuery {
        Clothing.slice(Clothing.cid).select {
                (Clothing.itemType eq type)
            }.orderBy(Random()).limit(1).mapNotNull { toCid(it) }.singleOrNull()
        }


}

val clothingService = ClothingService()