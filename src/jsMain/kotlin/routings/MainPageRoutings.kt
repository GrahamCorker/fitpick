package routings

import bigComponents.BookmarkPage
import bigComponents.HomePage
import kotlinx.browser.document
import kotlinx.browser.localStorage
import react.*
import react.dom.*
import kotlinx.css.*
import kotlinx.css.properties.TextDecoration
import kotlinx.html.js.onClickFunction
import react.router.dom.browserRouter
import react.router.dom.route
import react.router.dom.routeLink
import react.router.dom.switch
import styled.css
import styled.styledButton
import styled.styledDiv
import styled.styledImg

//private val scope = MainScope()

val MainPageRoutes = functionalComponent<RProps> { _ ->
    browserRouter {
        styledDiv {
            css {
                display = Display.flex
                flexWrap = FlexWrap.wrap
                flexDirection = FlexDirection.rowReverse

            }
            routeLink("/") {
                styledImg {
                    css {
                        maxHeight = 35.px
                        maxWidth = 35.px
                        padding(horizontal = 15.px)
                    }
                    attrs {
                        src = "Home_Icon.png"
                    }
                }
            }
            routeLink("/settings") {
                styledImg {
                    css {
                        maxHeight = 35.px
                        maxWidth = 35.px
                        padding(horizontal = 15.px)
                    }
                    attrs {
                        src = "Gear_Icon.png"
                    }
                }
            }
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
                +"Logout"
                attrs {
                    onClickFunction = {
                        render(document.getElementById("root")) {
                            child(LoginAndSignupRoutes)
                            localStorage.clear()
                        }
                    }
                }
            }

        }

        switch {
            route("/settings") {
                div {
                    child(BookmarkPage)
                }
            }
            route("/") {
                div {
                    child(HomePage)
                }
            }
        }
    }
}
