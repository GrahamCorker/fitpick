import kotlinx.serialization.Serializable

@Serializable
data class ClothingItem(
        val cid: Int,
        val price: Double,
        val siteLink: String,
        val isAdult: Boolean,
        val genderPref: String,
        var title: String,
        val img: String,
        val itemType: String,
        var isBookmarked: Boolean
){
    companion object {
        const val path = "/clothingItem"
    }
}