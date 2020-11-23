package routings

import Account
import Login
import bigComponents.LoginPage
import bigComponents.SignupPage
import getUser
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.css.*
import kotlinx.css.properties.TextDecoration
import login
import react.*
import react.dom.div
import react.router.dom.browserRouter
import react.router.dom.route
import react.router.dom.routeLink
import react.router.dom.switch
import styled.css
import styled.styledButton
import styled.styledDiv


private val scope = MainScope()
val LoginAndSignupRoutes = functionalComponent<RProps> { _ ->
    useEffect(dependencies = listOf()) {
        scope.launch {
            login(Login("user1@gmail.com", "12345"))
        }
    }
    browserRouter {
        styledDiv {
            css {
                display = Display.flex
                flexWrap = FlexWrap.wrap
                flexDirection = FlexDirection.rowReverse
            }
            routeLink("/") {
                styledButton {
                    css {
                        backgroundColor = Color.white
                        border = "none"
                        color = Color.black
                        padding(10.px, 20.px)
                        textAlign = TextAlign.center
                        textDecoration = TextDecoration.none
                        display = Display.inlineBlock
                        fontSize = 16.px
                        fontWeight = FontWeight.bold
                        margin(4.px, 2.px)
                        cursor = Cursor.pointer
                        borderRadius = 16.px
                        hover {
                            backgroundColor = Color.red
                            color = Color.white
                        }
                    }
                    +"Login"
                }
            }
            routeLink("/signup") {
                styledButton {
                    css {
                        backgroundColor = Color.white
                        border = "none"
                        color = Color.black
                        padding(10.px, 20.px)
                        textAlign = TextAlign.center
                        textDecoration = TextDecoration.none
                        display = Display.inlineBlock
                        fontSize = 16.px
                        fontWeight = FontWeight.bold
                        margin(4.px, 2.px)
                        cursor = Cursor.pointer
                        borderRadius = 16.px
                        hover {
                            backgroundColor = Color.red
                            color = Color.white
                        }
                    }
                    +"Signup"
                }
            }
        }

        switch {
            route("/signup") {
                div {
                    child(SignupPage)
                }
            }
            route("/") {
                div {
                    child(LoginPage)
                }
            }
        }
    }
}
