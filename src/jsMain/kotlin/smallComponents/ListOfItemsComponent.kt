package smallComponents

import ClothingItem
import bigComponents.ClothingList
import react.*
import react.dom.*
import kotlinx.css.*
import styled.*

external interface ItemProps : RProps {
    var item:ClothingItem
}

val ListOfItems = functionalComponent<ItemProps> { props ->
    styledDiv{
        css {
            margin(horizontal = 12.px, vertical = 6.px)
            textAlign = TextAlign.center
            width = 200.px
            borderStyle = BorderStyle.solid
            borderWidth = 2.px
        }

        styledH3 {
            +props.item.title
        }

        p {
            +"Price: $${props.item.price}"
        }

        a {
            attrs.href = props.item.siteLink
            +"Site link"
        }

        //Added this to create \n between the link and the picture. For some reason it puts them on the same line
        p{+""}


        styledImg {
            css{
                height = LinearDimension.auto
                width = LinearDimension.auto
                maxHeight = 200.px
                maxWidth = 200.px
            }
            attrs {
                src = props.item.img
            }
        }
    }
}
