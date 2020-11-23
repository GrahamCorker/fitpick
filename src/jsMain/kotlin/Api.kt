import io.ktor.http.*
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import kotlinx.browser.localStorage

import kotlinx.browser.window

val endpoint = window.location.origin

val jsonClient = HttpClient {
    install(JsonFeature) { serializer = KotlinxSerializer() }
}

suspend fun login(login: Login) {
    val resp = jsonClient.post<Map<String, String>>(endpoint + Login.path) {
        contentType(ContentType.Application.Json)
        body = login
    }
    val token =  resp["token"]

    if (token == null) {
        error("Authentication failed")
    } else {
        //TODO: Local storage is not a secure way to do this
        //Either move to sessions or put this in an httponly cookie
        localStorage.setItem("token", token)
        //Note that a side effect of this is that in order to logout, you must run
        //localStorage.clear()
        //And route back to the homepage
    }
}

suspend fun getUser(): Account {
    return jsonClient.get("$endpoint/user") {
        header("Authorization", "Bearer ${localStorage.getItem("token")}")
    }
}

suspend fun getClothingList(): List<ClothingItem> {
    return jsonClient.get(endpoint + ClothingItem.path + "/all")
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
