package smallComponents

import ClothingItem
import react.*
import react.dom.*
import kotlinx.css.*
import styled.*

external interface ItemProps : RProps {
    var item:ClothingItem
    var isBookmark: Boolean
}

val ListOfItems = functionalComponent<ItemProps> { props ->
    val (bookmarkType, setBookmarkType) = useState(props.isBookmark)
    styledDiv {
        css {
            textAlign = TextAlign.center
            alignItems = Align.center
            borderStyle = BorderStyle.solid
            borderWidth = 3.px
            backgroundColor = Color.white
            height = 100.pct
            minWidth = 200.px
            overflowY = Overflow.auto
        }

        styledH2 {
            css {
                padding(left = 10.px)
            }
            +props.item.title
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
        p { +"" }


        styledImg {
            css {
                maxWidth = 95.pct
                maxHeight = 95.pct
            }
            attrs {
                src = props.item.img
            }
        }
    }
}

