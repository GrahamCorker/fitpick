package bigComponents

import Signup
import io.ktor.client.features.*
import react.*
import react.dom.*
import kotlinext.js.*
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.html.js.*
import kotlinx.css.*
import kotlinx.css.properties.TextDecoration
import kotlinx.css.properties.s
import kotlinx.css.properties.transition
import kotlinx.html.InputType
import smallComponents.InputComponent
import styled.*
import org.w3c.dom.HTMLSelectElement
import signUp

private val scope = MainScope()

val SignupPage = functionalComponent<RProps> { _ ->
    val (username, setUsername) = useState("test")
    val (password, setPassword) = useState("")
    val (email, setEmail) = useState("")
    val (zipcode, setZipcode) = useState("")
//    val (size, setSize) = useState("")
    val (gender, setGender) = useState("Female")
    val (hasSubmitted, setHasSubmitted) = useState(false)


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
                    margin(top = 30.pct)
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
                            setEmail(input)
                        }
                        type = InputType.email
                        placeholder = "Email"
                    }
                )
            }

            styledDiv{
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
                child (
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
                    display = Display.flex
                    marginLeft = LinearDimension.auto
                    marginRight = LinearDimension.auto
                    textAlign = TextAlign.center
                    maxHeight = 36.px
                    margin(vertical = 20.px)
                }

                styledP{
                    css {
                        color = Color.white
                        width = 15.pct
                        margin(vertical = LinearDimension.auto)
                    }
                    +"Gender: "
                }

                styledSelect {
                    css {
                        cursor = Cursor.pointer
                        width = 85.pct
                        height = 36.px
                        margin(left = 10.px)
                    }
                    attrs.onChangeFunction = {
                        val target = it.target as HTMLSelectElement
                        setGender(target.value)
                    }
                    option {
                        attrs.value = "Female"
                        +"Female"
                    }
                    option {
                        attrs.value = "Male"
                        +"Male"
                    }
                    option {
                        attrs.value = "Unisex"
                        +"Unisex"
                    }
                }
            }


            styledDiv {
                css {
                    margin(vertical = 20.px)
                }

                child (
                    InputComponent,
                    props = jsObject {
                        onChange = { input ->
                            setZipcode(input)
                        }
                        type = InputType.number
                        placeholder = "Zipcode"
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
                        padding( horizontal = 32.px)
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
                    +"Sign up"
                    attrs.onClickFunction = {
                        scope.launch {
                            try {
                                signUp(Signup(email, username, password, zipcode.toInt(), gender))
                                setHasSubmitted(true)
                            }catch(e: ServerResponseException) {
                                //show error message here Shiv
                            }
                        }
                    }
                }
            }

            styledP{
                css {
                    color = Color.white
                }
                if(hasSubmitted) {
                    +"Congrats on signing up!  Please return to the login page to login."
                }
            }
        }
    }
}
