package service

import models.Clothing
import ClothingItem
import DatabaseFactory.dbQuery
import org.jetbrains.exposed.sql.*
import org.joda.time.*

class ClothingService {

    private fun toClothingItem(row: ResultRow, isBookmarked: Boolean, elapsed: String): ClothingItem =
            ClothingItem(
                    cid = row[Clothing.cid],
                    price = row[Clothing.price].toDouble(),
                    siteLink = row[Clothing.siteLink],
                    isAdult = row[Clothing.isAdult],
                    genderPref = row[Clothing.genderPref],
                    title = row[Clothing.title],
                    img = row[Clothing.img],
                    itemType = row[Clothing.itemType],
                    isBookmarked = isBookmarked,
                    elapsed = elapsed
            )

    private fun toClothingWithBookmarks(clothingItem: ClothingItem, isBookmarked: Boolean, elapsed: String): ClothingItem =
            ClothingItem(
                    cid = clothingItem.cid,
                    price = clothingItem.price,
                    siteLink = clothingItem.siteLink,
                    isAdult = clothingItem.isAdult,
                    genderPref = clothingItem.genderPref,
                    title = clothingItem.title,
                    img = clothingItem.img,
                    itemType = clothingItem.itemType,
                    isBookmarked = isBookmarked,
                    elapsed = elapsed
            )

    private fun toCid(row:ResultRow): Int =
        row[Clothing.cid]


    //SELECT * FROM clothing;
    suspend fun getAllClothingItems(userId: Int): List<ClothingItem> {
        val clothes = dbQuery {
            Clothing.selectAll().map{toClothingItem(it, true, "")}
        }
        return clothes.map{clothes->
            toClothingWithBookmarks(clothes, bookmarkService.isClothingItemBookmarked(clothes.cid, userId), "")
        }
    }

    //SELECT * FROM clothing WHERE clothing.cid = id;
    suspend fun getClothingItemById(id: Int, userId: Int) : ClothingItem? {
        val clothingItem = dbQuery {
            Clothing.select{
                (Clothing.cid eq id)
            }.mapNotNull { toClothingItem(it, true, "") }.singleOrNull()
        }

        return toClothingWithBookmarks(clothingItem!!, bookmarkService.isClothingItemBookmarked(clothingItem.cid, userId), "")
    }

    //TODO: Put this function into getClothingItemById
    suspend fun getBookmarkedClothingItemById(cid: Int, createdAt: DateTime): ClothingItem? {
        return dbQuery {
            Clothing.select{
                (Clothing.cid eq cid)
            }.mapNotNull { toClothingItem(it, true, bookmarkService.getElapsedTime(createdAt)) }.singleOrNull()
        }
    }

    suspend fun getClothingItemByType(itemType: String, cid: Int, createdAt: DateTime): ClothingItem? {
       return dbQuery {
            Clothing.select{
                (Clothing.cid eq cid and (Clothing.itemType eq itemType))
            }.mapNotNull { toClothingItem(it, true, bookmarkService.getElapsedTime(createdAt)) }.singleOrNull()
        }
    }

    //TODO: add optional params isadult, price, and gender
    suspend fun getRandomClothingItem(type: String, gender: String): Int? {
        //TODO: Make this an enum using Shiv's pr
        if(gender == "all") {
            return dbQuery {
                Clothing.slice(Clothing.cid).select {
                    (Clothing.itemType eq type)
                }.orderBy(Random()).limit(1).mapNotNull { toCid(it) }.singleOrNull()
            }
        }

        return dbQuery {
            Clothing.slice(Clothing.cid).select {
                (Clothing.genderPref eq gender and (Clothing.itemType eq type))
            }.orderBy(Random()).limit(1).mapNotNull { toCid(it) }.singleOrNull()
        }
    }
}

val clothingService = ClothingService()