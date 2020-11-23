import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.serialization.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import service.*
import io.ktor.auth.jwt.jwt

val clothingList = mutableListOf(
    ClothingListItem("Shirt", 1),
    ClothingListItem("Pants", 2),
    ClothingListItem("Socks", 3)
)

fun main() {
    val accountService = AccountService()
    embeddedServer(Netty, 9090) {
        install(ContentNegotiation) {
            json()
        }
        install(CORS) {
            method(HttpMethod.Get)
            method(HttpMethod.Post)
            method(HttpMethod.Delete)
            anyHost()
        }
        install(Compression) {
            gzip()
        }
        install(Authentication) {
            jwt {
                verifier(SimpleJWT.jwt.verifier)
                validate {
                    UserIdPrincipal(it.payload.getClaim("name").asString())
                }
            }
        }

        DatabaseFactory.init()

        routing {
            post(Login.path) {
                val post = call.receive<Login>()
                val user = accountService.getAccountByEmail(post.email)
                if (user == null || post.password != user.password) {
                    error("Invalid Credentials")
                }
                val token = mapOf("token" to SimpleJWT.jwt.sign(user.email))
                println(token)
                call.respond(token)
            }
            post(Signup.path) {
                    val post = call.receive<Signup>()
                    val user = accountService.createAccount(post)
                    call.respond(HttpStatusCode.OK)
            }
            authenticate {
                get("/user") {
                    val principal = call.principal<UserIdPrincipal>() ?: error("No principal detected")
                    val userEmail = principal.name
                    val user = accountService.getAccountByEmail(userEmail) ?: error("User not found")
                    call.respond(accountService.toSerializableAccount(user))
                }
            }
            route(ClothingItem.path) {
                get("/all"){
                    val clothingList = clothingService.getAllClothingItems()
                    call.respond(clothingList)
                }
            }


            authenticate {
                route(OutfitWithClothes.path)
                {
                    get("/random-outfit"){
                        val randomOutfitObj = outfitService.generateRandomOutfit()
                        call.respond(randomOutfitObj)
                    }

                    get("/bookmarks"){
                        val principal = call.principal<UserIdPrincipal>() ?: error("No principal detected")
                        val userEmail = principal.name
                        val user = accountService.getAccountByEmail(userEmail) ?: error("User not found")
                        val fullUser = accountService.toSerializableAccount(user);
                        val outfitBookmarks = bookmarkService.getBookmarkedOutfits(fullUser.userId);
                        call.respond(outfitBookmarks);
                    }

                    post("/bookmark-outfit"){
                        val principal = call.principal<UserIdPrincipal>() ?: error("No principal detected")
                        val userEmail = principal.name
                        val user = accountService.getAccountByEmail(userEmail) ?: error("User not found")
                        val fullUser = accountService.toSerializableAccount(user);
                        val receivedOutfit = call.receive<OutfitWithClothes>();
                        bookmarkService.createAndBookmarkOutfit(receivedOutfit, fullUser.userId);
                        call.respond(HttpStatusCode.OK);
                    }

                    delete("/delete-outfit/{id}")
                    {
                        val id = call.parameters["id"]?.toInt() ?: error("Invalid delete request")
                        bookmarkService.deleteOutfitBookmark(id);
                        call.respond(HttpStatusCode.OK);
                    }
                }
            }

            route(ClothingListItem.path) {
                get {
                    call.respond(clothingList)
                }
                post {
                    clothingList += call.receive<ClothingListItem>()
                    call.respond(HttpStatusCode.OK)
                }
                delete("/{id}") {
                    val id = call.parameters["id"]?.toInt() ?: error("Invalid delete request")
                    clothingList.removeIf { it.id == id }
                    call.respond(HttpStatusCode.OK)
                }
            }
            get("/") {
                call.respondText(
                    this::class.java.classLoader.getResource("index.html")!!.readText(),
                    ContentType.Text.Html
                )
            }


            static("/") {
                resources("")
            }
        }
    }.start(wait = true)
}