package smallComponents

import kotlinx.css.*
import react.*
import react.dom.*
import kotlinx.html.js.*
import kotlinx.html.InputType
import org.w3c.dom.events.Event
import org.w3c.dom.HTMLInputElement
import styled.css
import styled.*

external interface InputProps : RProps {
//    var onSubmit: (String) -> Unit
    var onChange: (String) -> Unit
    var type: InputType
    var placeholder: String
    //Current types are "password" for password inputs and "text" for standard text inputs
}

val InputComponent = functionalComponent<InputProps> { props ->
    val (text, setText) = useState("")

//    val submitHandler : (Event) -> Unit = {
//        it.preventDefault()
//        setText("")
//        props.onSubmit(text)
//    }

    val changeHandler: (Event) -> Unit = {
        val value = (it.target as HTMLInputElement).value
        setText(value)
    }

    form {
//        attrs.onSubmitFunction = submitHandler
            styledInput (props.type) {
                css {
                    width = 100.pct
                    height = 30.px
                }
                attrs {
                    placeholder = props.placeholder
                    onChangeFunction = changeHandler
                    value = text
                    props.onChange(text)
                }
            }
    }
}
