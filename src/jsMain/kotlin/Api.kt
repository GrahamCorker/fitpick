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

suspend fun signUp(user: Signup) {
    jsonClient.post<Unit>(endpoint + "/user" + Signup.path) {
        contentType(ContentType.Application.Json)
        body = user
    }
}

suspend fun getUser(): Account {
    return jsonClient.get("$endpoint/user${Account.path}") {
        header("Authorization", "Bearer ${localStorage.getItem("token")}")
    }
}

suspend fun updateUser(user: Signup) {
    return jsonClient.put("$endpoint/user${Account.path}") {
        contentType(ContentType.Application.Json)
        header("Authorization", "Bearer ${localStorage.getItem("token")}")
        body = user
    }
}

suspend fun getClothingList(): List<ClothingItem> {
    return jsonClient.get(endpoint + ClothingItem.path + "/all"){
        header("Authorization", "Bearer ${localStorage.getItem("token")}")
    }
}

suspend fun getTopTenClothingItems(): List<ClothingItem> {
    return jsonClient.get(endpoint + ClothingItem.path + "/top-ten"){
        header("Authorization", "Bearer ${localStorage.getItem("token")}")
    }
}

//item type must be EXACTLY as typed:
// "headwear", "midSection", "lowerSection", "accessory", "footwear"
suspend fun getAllClothingBookmarks(itemType: String): List<ClothingItem> {
    return jsonClient.get(endpoint + ClothingItem.path + "/bookmarks/${itemType}"){
        header("Authorization", "Bearer ${localStorage.getItem("token")}")
    }
}

suspend fun bookmarkClothingItem(clothingItem: ClothingItem) {
    jsonClient.post<Unit>(endpoint + ClothingItem.path + "/bookmark-item") {
        contentType(ContentType.Application.Json)
        header("Authorization", "Bearer ${localStorage.getItem("token")}")
        body = clothingItem
    }
}

suspend fun deleteClothingItemBookmark(clothingItem: ClothingItem) {
    jsonClient.delete<Unit>(endpoint + ClothingItem.path + "/delete-item/${clothingItem.cid}"){
        header("Authorization", "Bearer ${localStorage.getItem("token")}")
    }
}

suspend fun bookmarkRandomizedOutfit(outfit: OutfitWithClothes) {
    jsonClient.post<Unit>(endpoint + OutfitWithClothes.path + "/bookmark-outfit") {
        contentType(ContentType.Application.Json)
        header("Authorization", "Bearer ${localStorage.getItem("token")}")
        body = outfit
    }
}

suspend fun getAllOutfitBookmarks(): List<OutfitWithClothes> {
    return jsonClient.get(endpoint + OutfitWithClothes.path + "/bookmarks") {
        header("Authorization", "Bearer ${localStorage.getItem("token")}")
    }
}

suspend fun getRandomizedOutfit(): OutfitWithClothes {
    return jsonClient.get(endpoint + OutfitWithClothes.path + "/random-outfit") {
        header("Authorization", "Bearer ${localStorage.getItem("token")}")
    }
}

suspend fun deleteOutfitBookmark(outfit: OutfitWithClothes) {
    jsonClient.delete<Unit>(endpoint + OutfitWithClothes.path + "/delete-outfit/${outfit.outfitId}"){
        header("Authorization", "Bearer ${localStorage.getItem("token")}")
    }
}