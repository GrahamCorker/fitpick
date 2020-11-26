package service

import models.Clothing
import ClothingItem
import DatabaseFactory.dbQuery
import io.ktor.client.features.*
import org.jetbrains.exposed.sql.*

class ClothingService {

    private fun toClothingItem(row: ResultRow, isBookmarked: Boolean): ClothingItem =
            ClothingItem(
                    cid = row[Clothing.cid],
                    price = row[Clothing.price].toDouble(),
                    siteLink = row[Clothing.siteLink],
                    isAdult = row[Clothing.isAdult],
                    genderPref = row[Clothing.genderPref],
                    title = row[Clothing.title],
                    img = row[Clothing.img],
                    itemType = row[Clothing.itemType],
                    isBookmarked = isBookmarked
            )

    private fun toClothingWithBookmarks(clothingItem: ClothingItem, isBookmarked: Boolean): ClothingItem =
            ClothingItem(
                    cid = clothingItem.cid,
                    price = clothingItem.price,
                    siteLink = clothingItem.siteLink,
                    isAdult = clothingItem.isAdult,
                    genderPref = clothingItem.genderPref,
                    title = clothingItem.title,
                    img = clothingItem.img,
                    itemType = clothingItem.itemType,
                    isBookmarked = isBookmarked
            )

    private fun toCid(row:ResultRow): Int =
        row[Clothing.cid]


    //SELECT * FROM clothing;
    suspend fun getAllClothingItems(userId: Int): List<ClothingItem> {
        val clothes = dbQuery {
            Clothing.selectAll().map{toClothingItem(it, true)}
        }
        return clothes.map{clothes->
            toClothingWithBookmarks(clothes, bookmarkService.isClothingItemBookmarked(clothes.cid, userId))
        }
    }

    //SELECT * FROM clothing WHERE clothing.cid = id;
    suspend fun getClothingItemById(id: Int, userId: Int) : ClothingItem? {
        val clothingItem = dbQuery {
            Clothing.select{
                (Clothing.cid eq id)
            }.mapNotNull { toClothingItem(it, true) }.singleOrNull()
        }

        return toClothingWithBookmarks(clothingItem!!, bookmarkService.isClothingItemBookmarked(clothingItem.cid, userId))

    }

    suspend fun getClothingItemByType(itemType: String, cid: Int): ClothingItem? {
       return dbQuery {
            Clothing.select{
                (Clothing.cid eq cid and (Clothing.itemType eq itemType))
            }.mapNotNull { toClothingItem(it, true) }.singleOrNull()
        }

    }

    //TODO: add optional params isadult, price, and gender
    suspend fun getRandomClothingItem(type: String) : Int? = dbQuery {
        Clothing.slice(Clothing.cid).select {
                (Clothing.itemType eq type)
            }.orderBy(Random()).limit(1).mapNotNull { toCid(it) }.singleOrNull()
        }


}

val clothingService = ClothingService()