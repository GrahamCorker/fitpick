package bigComponents

import Account
import Signup
import getUser
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
import smallComponents.UpdateType
import smallComponents.UpdateUser
import updateUser

private val scope = MainScope()
val SettingsPage = functionalComponent<RProps> { _ ->
    val (user, setUser) = useState<Account?>(null)

    useEffect(dependencies = listOf()) {
        scope.launch {
            setUser(getUser())
        }
    }

    div {
        child(
            UpdateUser,
            props = jsObject {
                username = user?.username
                email = user?.email
                gender = user?.gender
                zipcode = user?.zipcode.toString()
                updateType = UpdateType.UPDATE
            }
        )
    }
}