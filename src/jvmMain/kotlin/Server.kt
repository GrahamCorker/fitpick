import io.ktor.application.*
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

val clothingList = mutableListOf(
    ClothingListItem("Shirt", 1),
    ClothingListItem("Pants", 2),
    ClothingListItem("Socks", 3)
)

fun main() {
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

        DatabaseFactory.init()

        routing {
            route(ClothingItem.path) {
                get("/all"){
                    val clothingList = clothingService.getAllClothingItems()
                    call.respond(clothingList)
                }
            }
            route(OutfitWithClothes.path)
            {
                get("/random-outfit"){
                    val randomOutfitObj = outfitService.generateRandomOutfit()
                    call.respond(randomOutfitObj)
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