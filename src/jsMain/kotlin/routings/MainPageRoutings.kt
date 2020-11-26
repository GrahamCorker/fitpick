package routings

import bigComponents.BookmarkPage
import bigComponents.HomePage
import bigComponents.TopTen
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
import styled.*

//private val scope = MainScope()

val MainPageRoutes = functionalComponent<RProps> { _ ->
    val (currentPage, setCurrentPage) = useState("Home")

    browserRouter {
        styledDiv {
            css {
                display = Display.flex
                justifyContent = JustifyContent.spaceBetween
                padding(5.px)
                height = 75.px
            }

            styledImg {
                css {
                    maxHeight = 100.pct
                }
                attrs.src = "Dark_Text_FP.png"
            }

            styledDiv{
                css{
                    textAlign = TextAlign.center
                }
                styledP{
                    css{
                        fontFamily = "'Comic Sans MS', cursive, sans-serif"
                        fontSize = 250.pct
                        marginTop = 5.px
                    }
                    +currentPage
                }
            }

            styledDiv {
                css {
                    display = Display.flex
                    flexDirection = FlexDirection.rowReverse
                    justifyContent = JustifyContent.center
                    margin(vertical = LinearDimension.auto)
                }

                styledButton {
                    css {
                        backgroundColor = Color.black
                        border = "none"
                        color = Color.white
                        padding(10.px, 20.px)
                        textAlign = TextAlign.center
                        textDecoration = TextDecoration.none
                        display = Display.inlineBlock
                        fontSize = 20.px
                        fontWeight = FontWeight.bold
                        margin(horizontal = 10.px)
                        cursor = Cursor.pointer
                        borderRadius = 16.px
                        height = 50.px
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

                routeLink("/settings") {
                    styledImg {
                        css {
                            maxHeight = 50.px
                            padding(horizontal = 15.px)
                            if(currentPage == "Settings")
                            {
                                opacity = .30
                            }
                        }
                        attrs {
                            src = "Gear_Icon.png"
                            onClickFunction = { setCurrentPage ("Settings") }
                        }
                    }
                }

                routeLink("/topTen") {
                    styledImg {
                        css {
                            maxHeight = 50.px
                            padding(horizontal = 15.px)
                            if(currentPage == "Top 10")
                            {
                                opacity = .30
                            }
                        }
                        attrs {
                            src = "Star_Icon.png"
                            onClickFunction = { setCurrentPage ("Top 10") }
                        }
                    }
                }

                routeLink("/bookmark") {
                    styledImg {
                        css {
                            maxHeight = 50.px
                            padding(horizontal = 15.px)
                            if(currentPage == "Bookmarks")
                            {
                                opacity = .30
                            }
                        }
                        attrs {
                            src = "Bookmark_Icon.png"
                            onClickFunction = { setCurrentPage ("Bookmarks") }
                        }
                    }
                }

                routeLink("/") {
                    styledImg {
                        css {
                            maxHeight = 50.px
                            padding(horizontal = 15.px)
                            if(currentPage == "Home")
                            {
                                opacity = .30
                            }
                        }
                        attrs {
                            src = "Home_Icon.png"
                            onClickFunction = { setCurrentPage ("Home") }
                        }
                    }
                }
            }
        }

        switch {
            route("/bookmark") {
                div {
                    child(BookmarkPage)
                }
            }
            route("/topTen") {
                div {
                    child(TopTen)
                }
            }
            route("/settings") {
                div {
                    //TODO Add the settings page child here
                    //child(TopTen)
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
