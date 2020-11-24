import kotlinx.serialization.Serializable

@Serializable
data class OutfitWithClothes(
    val outfitId: Int,
    val headWear: ClothingItem?,
    val midSection: ClothingItem?,
    val lowerSection: ClothingItem?,
    val footWear: ClothingItem?,
    val accessory: ClothingItem?
){
    companion object {
        const val path = "/outfit"
    }
}
