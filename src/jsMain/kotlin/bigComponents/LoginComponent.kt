package bigComponents

import Login
import react.*
import react.dom.*
import kotlinext.js.*
import kotlinx.browser.document
import kotlinx.browser.localStorage
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.css.*
import kotlinx.css.properties.TextDecoration
import kotlinx.css.properties.s
import kotlinx.css.properties.transition
import kotlinx.html.InputType
import kotlinx.html.js.onClickFunction
import login
import routings.MainPageRoutes
import smallComponents.InputComponent
import styled.css
import styled.styledButton
import styled.styledDiv
import styled.styledImg


private val scope = MainScope()
val LoginPage = functionalComponent<RProps> { _ ->
    val (username, setUsername) = useState("")
    val (password, setPassword) = useState("")

    styledDiv {
        css {
            backgroundImage = Image("url('Login_Page.jpg')")
            position = Position.fixed
            height = 100.pct
            width = 100.pct
            backgroundRepeat = BackgroundRepeat.noRepeat
            backgroundSize = "cover"
        }
        styledDiv {
            css {
                width = 400.px
                marginLeft = 5.pct
                textAlign = TextAlign.center
            }

            styledImg {
                css {
                    margin(top = 40.pct)
                }
                attrs.src = "Grey_Login_Icon.png"
            }

            styledDiv {
                css {
                    margin(vertical = 20.px)
                }
                child(
                        InputComponent,
                        props = jsObject {
                            onChange = { input ->
                                setUsername(input)
                            }
                            type = InputType.text
                            placeholder = "Username"
                        }
                )
            }


            styledDiv {
                css {
                    margin(vertical = 20.px)
                }
                child(
                        InputComponent,
                        props = jsObject {
                            onChange = { input ->
                                setPassword(input)
                            }
                            type = InputType.password
                            placeholder = "Password"
                        }
                )
            }

            styledDiv {
                css {
                    margin(vertical = 20.px)
                }
                styledButton {
                    css {
                        backgroundColor = Color.white
                        border = "none"
                        color = Color.black
                        padding(horizontal = 32.px)
                        textAlign = TextAlign.center
                        textDecoration = TextDecoration.none
                        display = Display.inlineBlock
                        fontSize = 16.px
                        fontWeight = FontWeight.bold
                        margin(4.px, 2.px)
                        height = 36.px
                        transition(duration = 0.4.s)
                        cursor = Cursor.pointer
                        hover {
                            backgroundColor = Color.red
                            color = Color.white
                        }
                    }
                    +"Login"
                    attrs.onClickFunction = {
                        //TODO do this idiomatically
                        scope.launch {
                            login(Login(username, password))
                            if (localStorage.getItem("token") != null) {
                                render(document.getElementById("root")) {
                                    child(MainPageRoutes)
                                }
                            } else {
                                //Hey Shiv, can you render an error message here?
                            }
                        }
                    }
                }
            }
        }
    }
}

//    p{
//        +"Entered Username: "
//        +username
//    }
//
//    p{
//        +"Entered Password: "
//        +password
//    }


