package routes

import Signup
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import models.FullAccount
import service.AccountService

fun Route.userRoutes() {
    val accountService = AccountService()
    route("/user") {
        post(Signup.path) {
            val post = call.receive<Signup>()
            val user = accountService.createAccount(post)
            call.respond(HttpStatusCode.OK)
        }
        authenticate {
            get(Account.path) {
                val principal = call.principal<UserIdPrincipal>() ?: error("No principal detected")
                val userEmail = principal.name
                val user = accountService.getAccountByEmail(userEmail) ?: error("User not found")
                call.respond(accountService.toSerializableAccount(user))
            }
            put(Account.path) {
                val principal = call.principal<UserIdPrincipal>() ?: error("No principal detected")
                val userEmail = principal.name
                val user = accountService.getAccountByEmail(userEmail) ?: error("User not found")
                val post = call.receive<Signup>()
                accountService.updateAccount(FullAccount(
                        userId = user.userId,
                        username = if(post.username == "") user.username else post.username,
                        password = if(post.password == "") user.password else post.password,
                        email = if(post.email == "") user.email else post.email,
                        gender = if(post.gender == "") user.gender else post.gender,
                        zipcode = post.zipcode
                ))
                call.respond(HttpStatusCode.OK)
            }
        }
    }
}