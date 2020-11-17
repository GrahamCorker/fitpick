import react.*
import react.dom.*
import kotlinext.js.*
import kotlinx.browser.document
import kotlinx.html.js.*
import kotlinx.css.*
import kotlinx.html.InputType
import smallComponents.InputComponent
import styled.*
import org.w3c.dom.HTMLSelectElement

//Do we need this line below?
//private val scope = MainScope()

val SignupPage = functionalComponent<RProps> { _ ->
    val (username, setUsername) = useState("")
    val (password, setPassword) = useState("")
    val (email, setEmail) = useState("")
    val (zipcode, setZipcode) = useState("")
    val (size, setSize) = useState("")
    val (gender, setGender) = useState("")

    styledH1{
        +"Signup PAGE"
    }

    styledDiv{
        css {
            margin(vertical = 20.px)
        }
        label {
            +"Enter Email: "
        }
        child (
            InputComponent,
            props = jsObject {
                onSubmit = { input ->
                    setEmail(input)
                }
                onChange = { input ->
                    setEmail(input)
                }
                type = InputType.email
            }
        )
    }

    styledDiv {
        css {
            margin(vertical = 20.px)
        }
        label {
            +"Enter Username: "
        }

        child (
                InputComponent,
                props = jsObject {
                    onSubmit = { input ->
                        setUsername(input)
                    }
                    onChange = { input ->
                        setUsername(input)
                    }
                    type = InputType.text
                }
        )
    }

    styledDiv {
        css {
            margin(vertical = 20.px)
        }

        label {
            +"Enter Password: "
        }

        child (
            InputComponent,
            props = jsObject {
                onSubmit = { input ->
                    setPassword(input)
                }
                onChange = { input ->
                    setPassword(input)
                }
                type = InputType.password
            }
        )
    }
    styledDiv{
        css {
            margin(vertical = 20.px)
        }

        label {
            +"Size: "
        }

        select {
            attrs.onChangeFunction = {
                val target = it.target as HTMLSelectElement
                setSize(target.value)
            }
            option {
                attrs.value = "Adult"
                +"Adult"
            }
            option {
                attrs.value = "Kids"
                +"Kids"
            }
        }
    }
    styledDiv {
        css {
            margin(vertical = 20.px)
        }

        label {
            +"Gender: "
        }

        select {
            attrs.onChangeFunction = {
                val target = it.target as HTMLSelectElement
                setGender(target.value)
            }
            option{
                attrs.value = "Female"
                +"Female"
            }
            option{
                attrs.value = "Male"
                +"Male"
            }
            option{
                attrs.value = "Unisex"
                +"Unisex"
            }
        }
    }

    styledDiv{
        css {
            margin(vertical = 20.px)
        }
        label {
            +"Enter Zipcode: "
        }

        child (
            InputComponent,
            props = jsObject {
                onSubmit = { input ->
                    setZipcode(input)
                }
                onChange = { input ->
                    setZipcode(input)
                }
                type = InputType.number
            }
        )
    }

    styledDiv{
        css {
            margin(vertical = 20.px)
        }
        button {
            +"Sign up"
            attrs.onClickFunction = {
//                render(document.getElementById("root")) {
//                    child(LoginPage)
//                }
            }
        }
    }

    p{
        +"Entered Username: "
        +username
    }
    p{
        +"Entered Password: "
        +password
    }
    p{
        +"Entered Email: "
        +email
    }
    p{
        +"Entered Zipcode: "
        +zipcode
    }
    p{
        +"Entered Size: "
        +size
    }
    p{
        +"Entered Gender: "
        +gender
    }
}
