package service
import models.Outfit
import models.OutfitObj
import DatabaseFactory.dbQuery
import OutfitWithClothes
import org.jetbrains.exposed.sql.*


class OutfitService {


    //TODO: Move this into models
    //Converts Rows of query to Outfit with cids
    private fun toOutfit(row: ResultRow): OutfitObj {
        return OutfitObj(
            outfitId = row[Outfit.outfitID],
            headWear = row[Outfit.headWear],
            midSection = row[Outfit.midSection],
            lowerSection = row[Outfit.lowerSection],
            accessory = row[Outfit.midSection],
            footWear = row[Outfit.midSection]
        )
    }

    //SELECT * FROM outfit
    suspend fun getAllOutfits(): List<OutfitObj> = dbQuery {
        Outfit.selectAll().map{toOutfit(it)}
    }

    //TODO: Move this into models
    //Function to convert a vanilla outfit to an Outfit Object with Clothes properties
    suspend fun toCompleteOutfit(outfitObj: OutfitObj): OutfitWithClothes{
        return OutfitWithClothes(
            outfitId = outfitObj.outfitId,
            headWear = clothingService.getClothingItemById(outfitObj.headWear),
            midSection = clothingService.getClothingItemById(outfitObj.midSection),
            lowerSection = clothingService.getClothingItemById(outfitObj.lowerSection),
            accessory = clothingService.getClothingItemById(outfitObj.accessory),
            footWear = clothingService.getClothingItemById(outfitObj.footWear),
        )
    }

    //TODO: Move this into models
    //Converts a list of vanilla outfits and returns a list of Outfit objects with Clothes properties
    suspend fun listToOutfitObj(outfitList: List<OutfitObj>): List<OutfitWithClothes>{
        val listOfOutfits = mutableListOf<OutfitWithClothes>()
        for (outfitObj in outfitList) {
            listOfOutfits.add(toCompleteOutfit(outfitObj))
        }
        return listOfOutfits;
    }

    //Get outfit id -- SELECT * FROM outfit WHERE id = outfitId
    suspend fun getOutfitById(id: Int): OutfitObj? = dbQuery {
        Outfit.select{
            (Outfit.outfitID eq id)
        }.mapNotNull { toOutfit(it) }.singleOrNull()
    }

    //Inserts an outfit into the database and returns its outfitId
    suspend fun generateRandomOutfit(): OutfitWithClothes {
        val cidHead = clothingService.getRandomClothingItem("headwear")
        val cidMid = clothingService.getRandomClothingItem("midSection")
        val cidLow = clothingService.getRandomClothingItem("lowerSection")
        val cidAcc = clothingService.getRandomClothingItem("accessory")
        val cidFoot = clothingService.getRandomClothingItem("footwear")
        val outfit = OutfitObj(
            outfitId = 0,
            headWear = cidHead!!,
            midSection = cidMid!!,
            lowerSection = cidLow!!,
            accessory = cidAcc!!,
            footWear = cidFoot!!
        )

        return toCompleteOutfit(outfit)

    }




}

val outfitService = OutfitService()