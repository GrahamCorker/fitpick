package smallComponents

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
import styled.*
import org.w3c.dom.HTMLSelectElement
import signUp
import updateUser

enum class UpdateType {
    SIGNUP,
    UPDATE
}

//TODO: Find a better, less rigid way to do the zipcode
interface UpdateUserProps : RProps {
    var username: String?
    var email: String?
    var zipcode: String?
    var gender: String?
    var updateType: UpdateType
}

private val scope = MainScope()

val UpdateUser = functionalComponent<UpdateUserProps> { props ->
    val (username, setUsername) = useState(props.username)
    val (password, setPassword) = useState("")
    val (email, setEmail) = useState(props.email)
    val (zipcode, setZipcode) = useState(props.zipcode)
    val (gender, setGender) = useState(if(props.gender == null) "Female" else props.gender)
    val (message, setMessage) = useState("")


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
                            placeholder = if(props.email == null) "Email" else props.email!!
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
                            placeholder = if(props.email == null) "Username" else props.username!!
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
                        if(props.gender == "Female") attrs.selected = true
                        attrs.value = "Female"
                        +"Female"
                    }
                    option {
                        if(props.gender == "Male") attrs.selected = true
                        attrs.value = "Male"
                        +"Male"
                    }
                    option {
                        if(props.gender == "Unisex") attrs.selected = true
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
                            placeholder = if(props.zipcode == null) "Zipcode" else props.zipcode!!
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

                    if(props.updateType == UpdateType.UPDATE) +"Update Settings" else +"Signup"

                    attrs.onClickFunction = {
                        //TODO: Validate password on update
                        if (email == null || (email == "" && props.updateType ==  UpdateType.SIGNUP) ||
                                gender == null ||
                                username == null || (username == "" && props.updateType ==  UpdateType.SIGNUP) ||
                                zipcode == null || (zipcode == "" && props.updateType ==  UpdateType.SIGNUP) ||
                                (password == "" && props.updateType ==  UpdateType.SIGNUP)
                        ) {
                            setMessage("Please fill out all fields")
                        } else {
                            scope.launch {
                                try {
                                    if (props.updateType == UpdateType.SIGNUP) {
                                        signUp(Signup(email, username, password, zipcode.toInt(), gender))
                                        setMessage("Congrats on signing up!  Please return to the login page to login.")
                                    } else if (props.updateType == UpdateType.UPDATE) {
                                        //TODO: Allow nullable fields in order to make this more type safe
                                        if(zipcode == "") {
                                            updateUser(Signup(email, username, password, props.zipcode!!.toInt(), gender))
                                        } else {
                                            updateUser(Signup(email, username, password, zipcode.toInt(), gender))
                                        }
                                        setMessage("You have updated your user profile!")
                                    }
                                } catch (e: ServerResponseException) {
                                    setMessage("A user with these values cannot be created.  Please change the entered username, email, or both.")
                                } catch (e: NumberFormatException) {
                                    setMessage("The zipcode you have entered is not a number")
                                }
                            }
                        }
                    }
                }
            }

            styledP{
                css {
                    color = Color.white
                }
                +message
            }
        }
    }
}