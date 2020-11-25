package bigComponents

import ClothingItem
import OutfitWithClothes
import bookmarkClothingItem
import getAllClothingBookmarks
import getAllOutfitBookmarks
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
import smallComponents.OutfitCard
import kotlin.math.round


var dummyIndex:Int = 0
private val scope = MainScope()
val BookmarkPage = functionalComponent<RProps> { _ ->
    var index:Int = 1
    val (category, setcategory) = useState("headwear")
    val (gender, setGender) = useState("all")
    val (selectitem, setselectitem) = useState<ClothingItem?>(null)
    val (clothingList, setClothingList) = useState(emptyList<ClothingItem>())
    val (outfitList, setOutfitList) = useState(emptyList<OutfitWithClothes>())
    val (currentOutfit, setCurrentOutfit) = useState<OutfitWithClothes?>(null)
    val (dummyState, setdummyState) = useState(0)

    useEffect(dependencies = listOf()) {
        scope.launch {
            //setClothingList(getClothingList())
            setClothingList(getAllClothingBookmarks("headwear"))
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

        styledDiv {
            css {
                display = Display.flex
                flexDirection = FlexDirection.row
                width = 40.pct
                margin(horizontal = LinearDimension.auto)
                marginTop = 40.px
                justifyContent = JustifyContent.spaceEvenly
            }

            styledButton {
                css {
                    width = 20.pct
                    height = 60.px
                    if (gender != "male") {
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
                +"Male"
                attrs {
                    onClickFunction = {
                        setGender("male")
                    }
                }
            }

            styledButton {
                css {
                    width = 20.pct
                    height = 60.px
                    if (gender != "female") {
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
                +"Female"
                attrs {
                    onClickFunction = {
                        setGender("female")
                    }
                }
            }

            styledButton {
                css {
                    width = 20.pct
                    height = 60.px
                    if (gender != "unisex") {
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
                +"Unisex"
                attrs {
                    onClickFunction = {
                        setGender("unisex")
                    }
                }
            }

            styledButton {
                css {
                    width = 20.pct
                    height = 60.px
                    if (gender != "all") {
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
                +"All"
                attrs {
                    onClickFunction = {
                        setGender("all")
                    }
                }
            }
        }

        styledDiv {
            css {
                display = Display.flex
                flexDirection = FlexDirection.row
                height = 70.pct
                minHeight = 500.px
                maxHeight = 600.px
                marginTop = 30.px
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
                            if (category != "headwear") {
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
                                scope.launch {
                                    setClothingList(getAllClothingBookmarks("headwear"))
                                }
                                setcategory("headwear")
                            }
                        }
                    }
                }
                div {
                    styledButton {
                        css {
                            width = 90.pct
                            height = 60.px
                            if (category != "midSection") {
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
                                scope.launch {
                                    setClothingList(getAllClothingBookmarks("midSection"))
                                }
                                setcategory("midSection")
                            }
                        }
                    }
                }
                div {
                    styledButton {
                        css {
                            width = 90.pct
                            height = 60.px
                            if (category != "lowerSection") {
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
                                scope.launch {
                                    setClothingList(getAllClothingBookmarks("lowerSection"))
                                }
                                setcategory("lowerSection")
                            }
                        }
                    }
                }
                div {
                    styledButton {
                        css {
                            width = 90.pct
                            height = 60.px
                            if (category != "footwear") {
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
                                scope.launch {
                                    setClothingList(getAllClothingBookmarks("footwear"))
                                }
                                setcategory("footwear")
                            }
                        }
                    }
                }
                div {
                    styledButton {
                        css {
                            width = 90.pct
                            height = 60.px
                            if (category != "accessory") {
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
                                scope.launch {
                                    setClothingList(getAllClothingBookmarks("accessory"))
                                }
                                setcategory("accessory")
                            }
                        }
                    }
                }
                div {
                    styledButton {
                        css {
                            width = 90.pct
                            height = 60.px
                            if (category != "outfit") {
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
                                scope.launch {
                                    setOutfitList(getAllOutfitBookmarks())
                                }
                                setcategory("outfit")
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
                        if(category =="outfit") {
                            outfitList.forEach { outfit ->
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
                                                marginLeft = 10.px
                                            }
                                            +"Saved Outfit $index"
                                        }
                                    }
                                    //TODO How to show the price here without having to add them all up
                                    styledDiv {
                                        css {
                                            display = Display.flex
                                            flexDirection = FlexDirection.rowReverse
                                            width = 20.pct
                                            marginRight = 5.px
                                            opacity = 1
                                        }
                                        p {
                                            if (currentOutfit != null) {
                                                +"$${round(outfit.headWear!!.price + outfit.midSection!!.price +
                                                        outfit.lowerSection!!.price + outfit.footWear!!.price + outfit.accessory!!.price)}"
                                            }
                                        }
                                    }
                                    attrs {
                                        onClickFunction = {
                                            setCurrentOutfit(outfit)
                                        }
                                    }
                                }
                                index += 1
                            }
                        }
                        else {
                            //TODO FIGURE OUT THE GENDER OPTIONS
                            clothingList.forEach { temp ->
                                console.log(temp)
                            if (temp.itemType == category && temp.genderPref == gender || gender == "all") {
                                styledDiv {
                                    css {
                                        display = Display.flex
                                        flexDirection = FlexDirection.row
                                        borderBottomStyle = BorderStyle.solid
                                        borderRightStyle = BorderStyle.solid
                                        cursor = Cursor.pointer
                                    }
                                    styledDiv {
                                        if (temp.isAdult) {
                                            styledImg {
                                                css {
                                                    marginTop = 0.px
                                                    height = 30.px
                                                    cursor = Cursor.pointer
                                                }
                                                attrs.src = "Bookmark_Icon.png"
                                                attrs.onClickFunction = {
                                                    temp.isAdult = false
                                                    dummyIndex += 1
                                                    setdummyState(dummyIndex)
                                                }
                                            }
                                        } else {
                                            styledImg {
                                                css {
                                                    marginTop = 0.px
                                                    height = 30.px
                                                    cursor = Cursor.pointer
                                                }
                                                attrs.src = "Selected_Bookmark_Icon.png"
                                                attrs.onClickFunction = {
                                                    temp.isAdult = true
                                                    dummyIndex += 1
                                                    setdummyState(dummyIndex)
                                                }
                                            }
                                        }
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
                }
            }

            styledDiv {
                css {
                    width = 25.pct
                    marginLeft = 10.px
                }
                if (category == "outfit"){
                    if (currentOutfit != null){
                        child (
                            OutfitCard,
                            props = jsObject {
                                console.log(currentOutfit)
                                item = currentOutfit
                            }
                        )
                    }
                } else {
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

        styledH1{
            css {
                display = Display.none
            }
            +"$dummyState"
        }
    }
}


