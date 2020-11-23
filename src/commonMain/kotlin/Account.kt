import kotlinx.serialization.Serializable

@Serializable
data class Account(
    val userId: Int,
    val gender: String,
    val zipcode: Int,
    val username: String,
    val email: String
){
    companion object{
        const val path = "/account"
    }
}

@Serializable
data class Login(val email: String, val password: String) {
    companion object{
        const val path = "/login"
    }
}

@Serializable
data class Signup(
    val email: String,
    val password: String,
    val zipcode: Int,
    val gender: String
) {
    companion object{
        const val path = "/signup"
    }
}