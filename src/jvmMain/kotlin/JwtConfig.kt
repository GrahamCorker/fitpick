import com.auth0.jwt.*
import com.auth0.jwt.algorithms.*
import java.util.*

class SimpleJWT(secret: String) {
    private val validityInMs = 36_000_00 * 1
    private val algorithm = Algorithm.HMAC256(secret)

    val verifier: JWTVerifier = JWT.require(algorithm).build()
    fun sign(name: String): String = JWT.create()
        .withClaim("name", name)
        .withExpiresAt(getExpiration())
        .sign(algorithm)

    private fun getExpiration() = Date(System.currentTimeMillis() + validityInMs)

    //TODO: Find out if this is an idiomatic way to implement this pattern
    //It looks like pure objects can be used as Singletons.  This likely accomplishes something similar
    //Look into if this is a reasonable case for not just making SimpleJWT an object
    companion object JWTSingleton {
        val jwt = SimpleJWT("thisshouldbereplacedwithsomethingsecure")
    }
}