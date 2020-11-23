package service
import models.Outfit
import models.OutfitBookmark
import DatabaseFactory.dbQuery
import OutfitWithClothes
import models.OutfitObj
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.insertAndGetId
import models.savesOutfit

class BookmarkService {

    private fun toOutfitBookmark(row: ResultRow): OutfitBookmark =
        OutfitBookmark(
            outfitID = row[savesOutfit.outfitID],
            userId = row[savesOutfit.userId],
            createdAt = row[savesOutfit.createdAt]
        )


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




}

val bookmarkService = BookmarkService();