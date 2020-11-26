package service
import DatabaseFactory.dbQuery
import OutfitWithClothes
import ClothingItem
import models.*
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.insertAndGetId

class BookmarkService {


    private fun toOutfitBookmark(row: ResultRow): OutfitBookmark =
        OutfitBookmark(
            outfitID = row[savesOutfit.outfitID],
            userId = row[savesOutfit.userId],
            createdAt = row[savesOutfit.createdAt]
        )

    private fun toClothingBookmark(row:ResultRow): ClothingBookmark =
        ClothingBookmark(
            cid = row[savesClothing.cid],
            userId = row[savesClothing.userId],
            createdAt = row[savesClothing.createdAt]
        )

    suspend fun createClothingBookmark(cid: Int, userId: Int) = dbQuery {
        savesClothing.insert {
            it[savesClothing.cid] = cid;
            it[savesClothing.userId] = userId;
        }
    }

    suspend fun getBookmarkedClothingItems(itemType: String, userId:Int): List<ClothingItem?> {
        val clothingBookmarks = dbQuery {
            savesClothing.select {
                (savesClothing.userId eq userId)
            }.mapNotNull { toClothingBookmark(it) }
        }

        return clothingBookmarks.mapNotNull{clothingBookmark ->
            clothingService.getClothingItemByType(itemType, clothingBookmark.cid)
        }
    }

    suspend fun getTopTenClothingItems(userId: Int):List<ClothingItem> {
        val mostBookmarked = dbQuery {
            savesClothing.slice(savesClothing.cid, savesClothing.cid.count()).selectAll()
                .orderBy(savesClothing.cid.count() to SortOrder.DESC).limit(10)
                .groupBy (savesClothing.cid).mapNotNull{ it[savesClothing.cid]}
        }

        return mostBookmarked.map{mostBookmarked->
            clothingService.getClothingItemById(mostBookmarked, userId)!!
        }

    }

    suspend fun deleteBookmarkedClothingItem(cid: Int, userId: Int) = dbQuery {
        savesClothing.deleteWhere { (savesClothing.cid eq cid and (savesClothing.userId eq userId)) }
    }

    suspend fun createAndBookmarkOutfit(outfit: OutfitWithClothes, userId: Int) = dbQuery {
        val id = Outfit.insert{
            it[headWear] = outfit.headWear!!.cid
            it[midSection] = outfit.midSection!!.cid
            it[lowerSection] = outfit.lowerSection!!.cid
            it[accessory] = outfit.accessory!!.cid
            it[footWear] = outfit.footWear!!.cid
        } get Outfit.outfitID

        savesOutfit.insert{
            it[savesOutfit.outfitID] = id!!;
            it[savesOutfit.userId] = userId;
        }

    }

    suspend fun getBookmarkedOutfits(userId: Int): List<OutfitWithClothes>{
        val outfitBookmarks = dbQuery {
            savesOutfit.select{
                (savesOutfit.userId eq userId)
            }.mapNotNull { toOutfitBookmark(it) }
        }

        return outfitBookmarks.map{outfitBookmark ->
            outfitService.toCompleteOutfit(outfitService.getOutfitById(outfitBookmark.outfitID)!!)
        }

    }


    //TODO: Figure out how to make this cascade so we dont have to double delete
    suspend fun deleteOutfitBookmark(outfitId: Int) = dbQuery {
        savesOutfit.deleteWhere { savesOutfit.outfitID eq outfitId }
        Outfit.deleteWhere { Outfit.outfitID eq outfitId}
    }


    suspend fun isClothingItemBookmarked(cid: Int, userId: Int): Boolean {
        //check if cid is tied to any users in savesClothing. Convert to clothing bookmark, and if null, return false
        val bookmark = dbQuery {
            //this will return 1 and only 1 bookmark
            savesClothing.select{
                (savesClothing.cid eq cid and (savesClothing.userId eq userId))
            }.mapNotNull { toClothingBookmark(it) }
        }

        return !bookmark.isNullOrEmpty()

    }


}

val bookmarkService = BookmarkService();