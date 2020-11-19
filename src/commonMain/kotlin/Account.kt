import kotlinx.serialization.Serializable

@Serializable
data class Account(
    val userId: Int,
    val gender: String,
    val zipcode: Int,
    val username: String,
    val email: String,
    val password: String
){
    companion object{
        const val path = "/account"
    }
}