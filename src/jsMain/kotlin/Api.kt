import io.ktor.http.*
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer

import kotlinx.browser.window

val endpoint = window.location.origin

val jsonClient = HttpClient {
    install(JsonFeature) { serializer = KotlinxSerializer() }
}

suspend fun getClothingList(): List<ClothingListItem> {
    return jsonClient.get(endpoint + ClothingListItem.path)
}

suspend fun  addClothingListItem(clothingListItem: ClothingListItem) {
    jsonClient.post<Unit>(endpoint + ClothingListItem.path) {
        contentType(ContentType.Application.Json)
        body = clothingListItem
    }
}

suspend fun deleteClothingListItem(clothingListItem: ClothingListItem) {
    jsonClient.delete<Unit>(endpoint + ClothingListItem.path + "/${clothingListItem.id}")
}
