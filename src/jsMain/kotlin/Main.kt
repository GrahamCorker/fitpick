import react.child
import react.dom.render
import kotlinx.browser.document
import routings.LoginAndSignupRoutes

fun main() {
    render(document.getElementById("root")) {
        child(LoginAndSignupRoutes)
    }
}



