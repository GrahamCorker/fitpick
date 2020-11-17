package smallComponents

import react.*
import react.dom.*
import kotlinx.html.js.*
import kotlinx.html.InputType
import org.w3c.dom.events.Event
import org.w3c.dom.HTMLInputElement

external interface InputProps : RProps {
    var onSubmit: (String) -> Unit
    var onChange: (String) -> Unit
    var type: InputType
    //Current types are "password" for password inputs and "text" for standard text inputs
}

val InputComponent = functionalComponent<InputProps> { props ->
    val (text, setText) = useState("")

    val submitHandler : (Event) -> Unit = {
        it.preventDefault()
        setText("")
        props.onSubmit(text)
    }

    val changeHandler: (Event) -> Unit = {
        val value = (it.target as HTMLInputElement).value
        setText(value)
    }

    form {
        attrs.onSubmitFunction = submitHandler
            input (props.type) {
                attrs.onChangeFunction = changeHandler
                attrs.value = text
                props.onChange(text)
            }
    }
}
