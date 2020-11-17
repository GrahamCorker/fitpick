import react.*
import react.dom.*
import kotlinext.js.*
import kotlinx.html.InputType
import smallComponents.InputComponent


//Do we need this line below?
//private val scope = MainScope()
val LoginPage = functionalComponent<RProps> { _ ->
    val (username, setUsername) = useState("")
    val (password, setPassword) = useState("")
    h1{
        +"LOGIN PAGE"
    }


    div{
        h4{
            +"Enter Username"
        }
        child(
                InputComponent,
                props = jsObject {
                    onSubmit = {}
                    onChange = { input ->
                        setUsername(input)
                    }
                    type = InputType.text
                }
        )
    }
    div{
        h4{
            +"Enter Password"
        }
        child(
                InputComponent,
                props = jsObject {
                    onSubmit = {}
                    onChange = { input ->
                        setPassword(input)
                    }
                    type = InputType.password
                }
        )
    }

    p{
        +"Entered Username: "
        +username
    }

    p{
        +"Entered Password: "
        +password
    }
}
