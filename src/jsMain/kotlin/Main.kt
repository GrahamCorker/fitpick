import react.child
import react.dom.render
import kotlinx.browser.document
import kotlinx.css.TextAlign
import kotlinx.css.textAlign
import react.dom.*
import react.router.dom.*
import styled.css
import styled.styledDiv

fun main() {
    render(document.getElementById("root")) {
         browserRouter {
             div {
                 ul {
                     li {
                         routeLink("/"){ +"Login" }
                     }
                     li {
                         routeLink("/signup"){ +"Signup"}
                     }
                     li {
                         routeLink("/topten"){ +"Top ten" }
                     }
                 }

                 switch {
                     route("/signup"){
                         styledDiv {
                            css {
                                textAlign= TextAlign.center
                            }
                            child(SignupPage)
                         }
                     }
                     route("/topten"){
                         styledDiv {
                             css {
                                 textAlign= TextAlign.center
                             }
                             child(Top10Page)
                         }
                     }
                     route("/"){
                         styledDiv {
                             css {
                                 textAlign= TextAlign.center
                             }
                             child(LoginPage)
                         }
                     }
                 }
             }
         }
    }
}
