package bigComponents

import ClothingItem
import OutfitWithClothes
import bookmarkClothingItem
import deleteClothingItemBookmark
import deleteOutfitBookmark
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

object BookmarkPageStyles: StyleSheet("BookmarkPageStyles", isStatic = true) {
    val genderButton by css {
        width = 20.pct
        height = 60.px
    }

    val clothingButton by css {
        width = 90.pct
        height = 60.px
    }

    val sectionButton by css {
        borderStyle = BorderStyle.solid
        borderWidth = 3.px
        textAlign = TextAlign.center
        textDecoration = TextDecoration.none
        display = Display.inlineBlock
        fontSize = 16.px
        fontWeight = FontWeight.bold
        cursor = Cursor.pointer
        borderColor = Color.black
    }
}

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
                    if (gender != "male") {
                        backgroundColor = Color.floralWhite
                        color = Color.black
                    } else {
                        backgroundColor = Color.crimson
                        color = Color.white
                    }
                    +BookmarkPageStyles.genderButton
                    +BookmarkPageStyles.sectionButton
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
                    if (gender != "female") {
                        backgroundColor = Color.floralWhite
                        color = Color.black
                    } else {
                        backgroundColor = Color.crimson
                        color = Color.white
                    }
                    +BookmarkPageStyles.genderButton
                    +BookmarkPageStyles.sectionButton
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
                    if (gender != "unisex") {
                        backgroundColor = Color.floralWhite
                        color = Color.black
                    } else {
                        backgroundColor = Color.crimson
                        color = Color.white
                    }
                    +BookmarkPageStyles.genderButton
                    +BookmarkPageStyles.sectionButton
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
                    if (gender != "all") {
                        backgroundColor = Color.floralWhite
                        color = Color.black
                    } else {
                        backgroundColor = Color.crimson
                        color = Color.white
                    }
                    +BookmarkPageStyles.genderButton
                    +BookmarkPageStyles.sectionButton
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
                            //TODO: figure out how to reuse this conditional css
                            if (category != "headwear") {
                                backgroundColor = Color.floralWhite
                                color = Color.black
                            } else {
                                backgroundColor = Color.crimson
                                color = Color.white
                            }
                            +BookmarkPageStyles.clothingButton
                            +BookmarkPageStyles.sectionButton
                        }
                        +"Headwear"
                        attrs {
                            onClickFunction = {
                                scope.launch {
                                    setselectitem(null);
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
                                backgroundColor = Color.floralWhite
                                color = Color.black
                            } else {
                                backgroundColor = Color.crimson
                                color = Color.white
                            }
                            +BookmarkPageStyles.sectionButton
                        }
                        +"Midsection"
                        attrs {
                            onClickFunction = {
                                scope.launch {
                                    setselectitem(null);
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
                            if (category != "lowerSection") {
                                backgroundColor = Color.floralWhite
                                color = Color.black
                            } else {
                                backgroundColor = Color.crimson
                                color = Color.white
                            }
                            +BookmarkPageStyles.clothingButton
                            +BookmarkPageStyles.sectionButton
                        }
                        +"Lowersection"
                        attrs {
                            onClickFunction = {
                                scope.launch {
                                    setselectitem(null);
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
                            if (category != "footwear") {
                                backgroundColor = Color.floralWhite
                                color = Color.black
                            } else {
                                backgroundColor = Color.crimson
                                color = Color.white
                            }
                            +BookmarkPageStyles.clothingButton
                            +BookmarkPageStyles.sectionButton
                        }
                        +"Footwear"
                        attrs {
                            onClickFunction = {
                                scope.launch {
                                    setselectitem(null);
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
                            if (category != "accessory") {
                                backgroundColor = Color.floralWhite
                                color = Color.black
                            } else {
                                backgroundColor = Color.crimson
                                color = Color.white
                            }
                            +BookmarkPageStyles.clothingButton
                            +BookmarkPageStyles.sectionButton
                        }
                        +"Accessories"
                        attrs {
                            onClickFunction = {
                                scope.launch {
                                    setselectitem(null);
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
                            if (category != "outfit") {
                                backgroundColor = Color.floralWhite
                                color = Color.black
                            } else {
                                backgroundColor = Color.crimson
                                color = Color.white
                            }
                            +BookmarkPageStyles.clothingButton
                            +BookmarkPageStyles.sectionButton
                        }
                        +"Outfit"
                        attrs {
                            onClickFunction = {
                                scope.launch {
                                    setselectitem(null);
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
                    backgroundColor = Color.floralWhite
                }
                div {
                        if(category =="outfit") {
                            if(outfitList.isEmpty())
                            {
                                styledDiv{
                                    styledH4{
                                        css {
                                            marginLeft = 10.px
                                        }
                                        + "You do not have any bookmarked outfits :("
                                    }
                                }
                            }
                            else{
                                outfitList.forEach { outfit ->
                                    styledDiv {
                                        css {
                                            display = Display.flex
                                            flexDirection = FlexDirection.row
                                            borderBottomStyle = BorderStyle.solid
                                            borderRightStyle = BorderStyle.solid
                                            cursor = Cursor.pointer
                                            if(outfit == currentOutfit)
                                            {
                                                backgroundColor = Color.lightGray;
                                            }
                                        }
                                        styledDiv {
                                            if (outfit.isBookmarked) {
                                                styledImg {
                                                    css {
                                                        marginTop = 0.px
                                                        height = 30.px
                                                        cursor = Cursor.pointer
                                                    }
                                                    attrs.src = "Selected_Bookmark_Icon.png"
                                                    attrs.onClickFunction = {
                                                        outfit.isBookmarked = false
                                                        dummyIndex += 1
                                                        setdummyState(dummyIndex)
                                                    }
                                                }
                                            } else {
                                                styledImg {
                                                    css {
                                                        marginTop = 7.px
                                                        marginLeft = 5.px
                                                        marginRight = 5.px
                                                        height = 45.px
                                                        cursor = Cursor.pointer
                                                    }
                                                    attrs.src = "confirm-delete-icon.png"
                                                    attrs.onClickFunction = {
                                                        dummyIndex += 1
                                                        setdummyState(dummyIndex)
                                                        scope.launch{
                                                            setCurrentOutfit(null)
                                                            deleteOutfitBookmark(outfit)
                                                            setOutfitList(getAllOutfitBookmarks())
                                                        }
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
                                                    marginLeft = 10.px
                                                }
                                                +"Saved Outfit $index"
                                            }
                                            styledH3 {
                                                css{
                                                    margin(horizontal = 70.px)
                                                    margin(vertical = 23.px)
                                                    color = Color.cadetBlue
                                                    fontSize = 14.px
                                                }
                                                +outfit.elapsed
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
                        }
                        else {
                            //TODO FIGURE OUT THE GENDER OPTIONS
                            if(clothingList.isEmpty())
                            {
                                styledDiv{
                                    styledH4{
                                        css {
                                            marginLeft = 10.px
                                        }
                                        + "You do not have any bookmarked items of this type :("
                                    }
                                }
                            }
                            clothingList.forEach { temp ->
                            if (temp.itemType == category && temp.genderPref == gender || gender == "all") {
                                styledDiv {
                                    css {
                                        display = Display.flex
                                        flexDirection = FlexDirection.row
                                        borderBottomStyle = BorderStyle.solid
                                        borderRightStyle = BorderStyle.solid
                                        cursor = Cursor.pointer
                                        if(temp == selectitem) {
                                            backgroundColor = Color.lightGray;
                                        }
                                    }
                                    styledDiv {
                                        if (temp.isBookmarked) {
                                            styledImg {
                                                css {
                                                    marginTop = 0.px
                                                    height = 30.px
                                                    cursor = Cursor.pointer
                                                }
                                                //Currently bookmarked items are red
                                                attrs.src = "Selected_Bookmark_Icon.png"
                                                attrs.onClickFunction = {
                                                    temp.isBookmarked = false
                                                    dummyIndex += 1
                                                    setdummyState(dummyIndex)
                                                }
                                            }
                                        } else {
                                            styledImg {
                                                css {
                                                    marginTop = 7.px
                                                    marginLeft = 5.px
                                                    marginRight = 5.px
                                                    height = 45.px
                                                    cursor = Cursor.pointer
                                                }
                                                //Unbookmarked clothing items are black
                                                attrs.src = "confirm-delete-icon.png"
                                                attrs.onClickFunction = {
                                                    dummyIndex += 1
                                                    setdummyState(dummyIndex)
                                                    scope.launch{
                                                        setselectitem(null)
                                                        deleteClothingItemBookmark(temp)
                                                        setClothingList(getAllClothingBookmarks(temp.itemType))
                                                    }
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
                                        styledH3 {
                                            css{
                                                margin(horizontal = 70.px)
                                                margin(vertical = 23.px)
                                                color = Color.cadetBlue
                                                fontSize = 14.px
                                            }
                                            +temp.elapsed
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


