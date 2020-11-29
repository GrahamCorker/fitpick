package bigComponents

import ClothingItem
import OutfitWithClothes
import bookmarkClothingItem
import bookmarkRandomizedOutfit
import deleteClothingItemBookmark
import getClothingList
import getRandomizedOutfit
import react.*
import kotlinext.js.*
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.css.*
import kotlinx.css.properties.TextDecoration
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLSelectElement
import react.dom.h3
import react.dom.option
import smallComponents.ListOfItems
import smallComponents.OutfitCard
import styled.*

private val scope = MainScope()

val HomePage = functionalComponent<RProps> { _ ->
    val (randomBookmark, setRandomBookmark) = useState<OutfitWithClothes?>(null)
    val (clothingList, setClothingList) = useState(emptyList<ClothingItem>())
    val (dummyState, setdummyState) = useState(0)
    val (gender, setGender) = useState("all")
    val (clothingType, setClothingType) = useState("all")
    val (bookmark, setBookmark) = useState(false)

    useEffect(dependencies = listOf()) {
        scope.launch {
            setRandomBookmark(getRandomizedOutfit())
            setClothingList(getClothingList())
        }
    }

    styledDiv {
        css {

            backgroundImage = Image("url('Home_background_Page.jpg')")
            position = Position.fixed
            height = 100.pct
            width = 100.pct
            backgroundRepeat = BackgroundRepeat.noRepeat
            backgroundSize = "cover"
            overflow = Overflow.auto
        }

        styledDiv {
            css {
                display = Display.flex
                width = 80.pct
                height = 75.pct
                margin(horizontal = LinearDimension.auto)
                marginTop = 30.px
            }
            styledDiv {
                css {
                    display = Display.flex
                    flexDirection = FlexDirection.column
                    width = 75.pct
                }
                styledDiv {
                    css {
                        display = Display.flex
                        justifyContent = JustifyContent.center
                        alignItems = Align.center
                    }

                    h3 {
                        +"Clothing Type: "
                    }

                    styledSelect {
                        css {
                            cursor = Cursor.pointer
                            width = 20.pct
                            height = 36.px
                            margin(left = 10.px)
                            backgroundColor = Color.floralWhite
                        }
                        attrs.onChangeFunction = {
                            val target = it.target as HTMLSelectElement
                            setClothingType(target.value)
                        }
                        option {
                            attrs.value = ClothingTypeEnum.all.toString()
                            +"All"
                        }
                        option {
                            attrs.value = ClothingTypeEnum.headwear.toString()
                            +"Headwear"
                        }
                        option {
                            attrs.value = ClothingTypeEnum.midSection.toString()
                            +"MidSection"
                        }
                        option {
                            attrs.value = ClothingTypeEnum.lowerSection.toString()
                            +"LowerSection"
                        }
                        option {
                            attrs.value = ClothingTypeEnum.footwear.toString()
                            +"Footwear"
                        }
                        option {
                            attrs.value = ClothingTypeEnum.accessory.toString()
                            +"Accessory"
                        }
                    }

                    styledH3 {
                        css {
                            marginLeft = 50.px
                        }
                        +"Gender: "
                    }

                    styledSelect {
                        css {
                            cursor = Cursor.pointer
                            width = 20.pct
                            height = 36.px
                            margin(left = 10.px)
                            backgroundColor = Color.floralWhite
                        }
                        attrs.onChangeFunction = {
                            val target = it.target as HTMLSelectElement
                            setGender(target.value)
                        }
                        option {
                            attrs.value = GenderEnum.all.toString()
                            +"All"
                        }
                        option {
                            attrs.value = GenderEnum.male.toString()
                            +"Male"
                        }
                        option {
                            attrs.value = GenderEnum.female.toString()
                            +"Female"
                        }
                        option {
                            attrs.value = GenderEnum.unisex.toString()
                            +"Unisex"
                        }
                    }
                }

                styledDiv {
                    css {
                        display = Display.flex
                        flexDirection = FlexDirection.row
                        flexWrap = FlexWrap.wrap
                        overflow = Overflow.auto
                        borderStyle = BorderStyle.solid
                        borderWidth = 2.px
                        backgroundColor = Color.floralWhite
                    }
                    clothingList.forEach { temp ->
                        if (temp.genderPref == gender || gender == GenderEnum.all.toString()) {
                            if (temp.itemType == clothingType || clothingType == ClothingTypeEnum.all.toString()) {
                                styledDiv {
                                    css {
                                        display = Display.flex
                                        flexDirection = FlexDirection.column
                                        alignItems = Align.center
                                    }
                                    styledButton {
                                        css {
                                            width = 70.pct
                                            height = LinearDimension.auto
                                            marginTop = 20.px
                                            borderTopLeftRadius = 15.px
                                            borderTopRightRadius = 15.px
                                            cursor = Cursor.pointer
                                            padding(horizontal = 15.px)
                                            paddingTop = 5.px
                                            outline = Outline.none
                                            borderBottom = "none"
                                            if (temp.isBookmarked) {
                                                color = Color.white
                                                backgroundColor = Color.crimson
                                            } else {
                                                color = Color.white
                                                backgroundColor = Color.cornflowerBlue
                                            }
                                        }
                                        if (temp.isBookmarked) {
                                            +"Bookmarked!"
                                        } else {
                                            +"Bookmark?"
                                        }
                                        attrs.onClickFunction = {
                                            if (temp.isBookmarked) {
                                                scope.launch {
                                                    deleteClothingItemBookmark(temp)
                                                }
                                                dummyIndex += 1
                                                setdummyState(dummyIndex)
                                                temp.isBookmarked = false
                                            } else if (!temp.isBookmarked) {
                                                scope.launch {
                                                    bookmarkClothingItem(temp)
                                                }
                                                dummyIndex += 1
                                                setdummyState(dummyIndex)
                                                temp.isBookmarked = true
                                            }
                                        }
                                    }

                                    styledDiv {
                                        css {
                                            height = 400.px
                                            width = 200.px
                                            margin(horizontal = 10.px)
                                            marginTop = 0.px
                                        }
                                        child(
                                                ListOfItems,
                                                props = jsObject {
                                                    item = temp
                                                }
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }

            styledDiv {
                css {
                    width = 25.pct
                    paddingLeft = 10.px
                    textAlign = TextAlign.center
                }
                styledDiv {
                    css {
                        display = Display.flex
                        paddingBottom = 5.px
                        paddingTop = 5.px
                    }
                    styledButton {
                        css {
                            backgroundColor = Color.floralWhite
                            color = Color.black
                            border = "none"
                            padding(vertical = 10.px)
                            width = 45.pct
                            textAlign = TextAlign.center
                            textDecoration = TextDecoration.none
                            display = Display.inlineBlock
                            fontSize = 16.px
                            fontWeight = FontWeight.bold
                            margin(4.px, 2.px)
                            cursor = Cursor.pointer
                            borderRadius = 16.px
                            borderStyle = BorderStyle.solid
                            borderWidth = 1.5.px
                            outline = Outline.none
                            hover {
                                backgroundColor = Color.red
                                color = Color.white
                            }
                        }
                        attrs.onClickFunction = {
                            setBookmark(false)
                            scope.launch {
                                setRandomBookmark(getRandomizedOutfit())
                            }
                        }
                        +"Randomize"
                    }

                    styledButton {
                        css {
                            if (bookmark){
                                backgroundColor = Color.red
                                color = Color.white
                            } else {
                                backgroundColor = Color.floralWhite
                                color = Color.black
                            }
                            border = "none"
                            padding(vertical = 10.px)
                            width = 45.pct
                            textAlign = TextAlign.center
                            textDecoration = TextDecoration.none
                            display = Display.inlineBlock
                            fontSize = 16.px
                            fontWeight = FontWeight.bold
                            margin(4.px, 2.px)
                            cursor = Cursor.pointer
                            borderRadius = 16.px
                            borderStyle = BorderStyle.solid
                            borderWidth = 1.5.px
                            outline = Outline.none
                            hover {
                                backgroundColor = Color.lightSalmon
                                color = Color.black
                            }
                        }
                        if (!bookmark){
                            attrs.onClickFunction = {
                                if (!bookmark){
                                    scope.launch {
                                        bookmarkRandomizedOutfit(randomBookmark!!)
                                    }
                                    setBookmark(true)
                                }
                            }
                        }
                        +"Bookmark"
                    }
                }

                styledDiv {
                    css {
                        height = 90.pct
                        width = 95.pct
                    }
                    if (randomBookmark != null) {
                        child(
                                OutfitCard,
                                props = jsObject {
                                    item = randomBookmark
                                }
                        )
                    }
                }
            }
        }
        styledH1 {
            css {
                display = Display.none
            }
            +"$dummyState"
        }
    }
}
