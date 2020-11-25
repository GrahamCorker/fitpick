package bigComponents

import react.RProps
import react.dom.h1
import react.functionalComponent

val TopTen = functionalComponent<RProps> { _ ->
    h1{
        +"Top 10 Page"
    }
}
