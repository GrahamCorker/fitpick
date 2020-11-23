package bigComponents

import ClothingItem
import getClothingList
import react.*
import react.dom.*
import kotlinext.js.*
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.html.js.*
import kotlinx.css.*
import kotlinx.css.properties.TextDecoration
import styled.*
import smallComponents.ListOfItems


private val scope = MainScope()
val BookmarkPage = functionalComponent<RProps> { _ ->
    var index:Int = 0
    val (category, setcategory) = useState("")
    val (selectitem, setselectitem) = useState<ClothingItem?>(null)
    val (clothingList, setClothingList) = useState(emptyList<ClothingItem>())

    useEffect(dependencies = listOf()) {
        scope.launch {
            setClothingList(getClothingList())
        }
    }

    styledDiv {
        css {
            backgroundImage = Image("url('Bookmark_Page.jpg')")
            position = Position.fixed
            height = 100.pct
            width = 100.pct
            backgroundRepeat = BackgroundRepeat.noRepeat
            backgroundSize = "cover"
        }

        styledDiv{
            css{
                textAlign = TextAlign.center
            }
            styledP{
                css{
                    fontFamily = "'Comic Sans MS', cursive, sans-serif"
                    fontSize = 250.pct
                }
                +"Bookmarks"
            }
        }

        styledDiv {
            css {
                display = Display.flex
                flexDirection = FlexDirection.row
                height = 70.pct
                minHeight = 500.px
                maxHeight = 600.px
                width = 80.pct
                margin(horizontal = 10.pct)
                position = Position.fixed
            }
            styledDiv {
                css {
                    display = Display.flex
                    flexDirection = FlexDirection.column
                    justifyContent = JustifyContent.spaceBetween
                    width = 25.pct
                    textAlign = TextAlign.center
                }
                div {
                    styledButton {
                        css {
                            width = 90.pct
                            height = 60.px
                            if (category != "Headwear") {
                                backgroundColor = Color.white
                                color = Color.black
                            } else {
                                backgroundColor = Color.red
                                color = Color.white
                            }
                            borderStyle = BorderStyle.solid
                            borderWidth = 3.px
                            textAlign = TextAlign.center
                            textDecoration = TextDecoration.none
                            display = Display.inlineBlock
                            fontSize = 16.px
                            fontWeight = FontWeight.bold
                            cursor = Cursor.pointer
                        }
                        +"Headwear"
                        attrs {
                            onClickFunction = {
                                setcategory("Headwear")
                            }
                        }
                    }
                }
                div {
                    styledButton {
                        css {
                            width = 90.pct
                            height = 60.px
                            if (category != "Midsection") {
                                backgroundColor = Color.white
                                color = Color.black
                            } else {
                                backgroundColor = Color.red
                                color = Color.white
                            }
                            borderStyle = BorderStyle.solid
                            borderWidth = 3.px
                            textAlign = TextAlign.center
                            textDecoration = TextDecoration.none
                            display = Display.inlineBlock
                            fontSize = 16.px
                            fontWeight = FontWeight.bold
                            cursor = Cursor.pointer
                        }
                        +"Midsection"
                        attrs {
                            onClickFunction = {
                                setcategory("Midsection")
                            }
                        }
                    }
                }
                div {
                    styledButton {
                        css {
                            width = 90.pct
                            height = 60.px
                            if (category != "Lowersection") {
                                backgroundColor = Color.white
                                color = Color.black
                            } else {
                                backgroundColor = Color.red
                                color = Color.white
                            }
                            borderStyle = BorderStyle.solid
                            borderWidth = 3.px
                            textAlign = TextAlign.center
                            textDecoration = TextDecoration.none
                            display = Display.inlineBlock
                            fontSize = 16.px
                            fontWeight = FontWeight.bold
                            cursor = Cursor.pointer
                        }
                        +"Lowersection"
                        attrs {
                            onClickFunction = {
                                setcategory("Lowersection")
                            }
                        }
                    }
                }
                div {
                    styledButton {
                        css {
                            width = 90.pct
                            height = 60.px
                            if (category != "Footwear") {
                                backgroundColor = Color.white
                                color = Color.black
                            } else {
                                backgroundColor = Color.red
                                color = Color.white
                            }
                            borderStyle = BorderStyle.solid
                            borderWidth = 3.px
                            textAlign = TextAlign.center
                            textDecoration = TextDecoration.none
                            display = Display.inlineBlock
                            fontSize = 16.px
                            fontWeight = FontWeight.bold
                            cursor = Cursor.pointer
                        }
                        +"Footwear"
                        attrs {
                            onClickFunction = {
                                setcategory("Footwear")
                            }
                        }
                    }
                }
                div {
                    styledButton {
                        css {
                            width = 90.pct
                            height = 60.px
                            if (category != "Accessories") {
                                backgroundColor = Color.white
                                color = Color.black
                            } else {
                                backgroundColor = Color.red
                                color = Color.white
                            }
                            borderStyle = BorderStyle.solid
                            borderWidth = 3.px
                            textAlign = TextAlign.center
                            textDecoration = TextDecoration.none
                            display = Display.inlineBlock
                            fontSize = 16.px
                            fontWeight = FontWeight.bold
                            cursor = Cursor.pointer
                        }
                        +"Accessories"
                        attrs {
                            onClickFunction = {
                                setcategory("Accessories")
                            }
                        }
                    }
                }
                div {
                    styledButton {
                        css {
                            width = 90.pct
                            height = 60.px
                            if (category != "Outfit") {
                                backgroundColor = Color.white
                                color = Color.black
                            } else {
                                backgroundColor = Color.red
                                color = Color.white
                            }
                            borderStyle = BorderStyle.solid
                            borderWidth = 3.px
                            textAlign = TextAlign.center
                            textDecoration = TextDecoration.none
                            display = Display.inlineBlock
                            fontSize = 16.px
                            fontWeight = FontWeight.bold
                            cursor = Cursor.pointer
                        }
                        +"Outfit"
                        attrs {
                            onClickFunction = {
                                setcategory("Outfit")
                            }
                        }
                    }
                }
            }

            styledDiv {
                css {
                    overflow = Overflow.auto
                    height = 100.pct
                    display = Display.flex
                    flexDirection = FlexDirection.column
                    width = 50.pct
                    borderTopStyle = BorderStyle.solid
                    borderLeftStyle = BorderStyle.solid
                    borderRightStyle = BorderStyle.solid
                    borderBottomStyle = BorderStyle.solid
                    backgroundColor = Color.white

                }
                div {
                    clothingList.forEach { temp ->
                        styledDiv {
                            css {
                                display = Display.flex
                                flexDirection = FlexDirection.row
                                borderBottomStyle = BorderStyle.solid
                                borderRightStyle = BorderStyle.solid
                                cursor = Cursor.pointer
                            }
                            styledDiv {
                                css {
                                    display = Display.flex
                                    flexDirection = FlexDirection.row
                                    width = 80.pct
                                }
                                styledH3 {
                                    css {
                                        marginLeft = 5.px
                                        marginRight = 10.px
                                    }
                                    +"$index. "
                                }
                                styledH3 {
                                    +temp.title
                                }
                            }
                            styledDiv {
                                css {
                                    display = Display.flex
                                    flexDirection = FlexDirection.rowReverse
                                    width = 20.pct
                                    marginRight = 5.px
                                    opacity = 1
                                }
                                p {
                                    +"$${temp.price}"
                                }
                            }
                            attrs {
                                onClickFunction = {
                                    setselectitem(temp)
                                }
                            }
                        }
                        index += 1
                    }
                }
            }

            styledDiv {
                css {
                    maxWidth = 25.pct
                    marginLeft = 10.px
                }
                if (selectitem != null) {
                    child(
                            ListOfItems,
                            props = jsObject {
                                item = selectitem
                            }
                    )
                }
            }
        }
    }
}


