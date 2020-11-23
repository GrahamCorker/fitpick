package smallComponents

import ClothingItem
import bigComponents.ClothingList
import react.*
import react.dom.*
import kotlinx.css.*
import kotlinx.html.js.onClickFunction
import styled.*

external interface ItemProps : RProps {
    var item:ClothingItem
}

val ListOfItems = functionalComponent<ItemProps> { props ->
    styledDiv{
        css {
            textAlign = TextAlign.center
            alignItems = Align.center
            borderStyle = BorderStyle.solid
            borderWidth = 3.px
            backgroundColor = Color.white
            height = 100.pct
            overflow = Overflow.auto
        }

        styledDiv {
            css {
                width =  LinearDimension.auto;
                marginTop = 30.px
            }
            styledH2 {
                css {
                    padding(horizontal = 5.px)
                }
                +props.item.title
            }
        }

        styledH3 {
            css {
                color = Color.blue
            }
            +"$${props.item.price}"
        }

        a {
            attrs.href = props.item.siteLink
            +"Shop Online"
        }

        //Added this to create \n between the link and the picture. For some reason it puts them on the same line
        p{+""}


        styledImg {
            css{
                maxWidth = 95.pct
                maxHeight = 95.pct
            }
            attrs {
                src = props.item.img
            }
        }
    }
}
