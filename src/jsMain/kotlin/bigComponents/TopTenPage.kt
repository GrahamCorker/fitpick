package bigComponents

import ClothingItem
import bookmarkClothingItem
import deleteClothingItemBookmark
import getTopTenClothingItems
import kotlinext.js.jsObject
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.css.*
import kotlinx.html.js.onClickFunction
import react.*
import styled.*
import smallComponents.ListOfItems

var dummyIndex1:Int = 0
private val scope = MainScope()
val TopTen = functionalComponent<RProps> { _ ->
    var index:Int = 1
    val (clothingList, setClothingList) = useState(emptyList<ClothingItem>())
    val (dummyState, setdummyState) = useState(0)

    useEffect(dependencies = listOf()) {
        scope.launch {
            setClothingList(getTopTenClothingItems())
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
            overflow=Overflow.auto
        }
        styledH1{
            css {
                textAlign = TextAlign.center
                fontSize = 25.px
                fontFamily = "'Comic Sans MS', cursive, sans-serif"
                margin(horizontal = 20.px)
                marginTop = 50.px
            }
            +"[Most Bookmarked Clothing Items]"
        }
        styledDiv {
            css {
                width = 70.pct
                marginLeft = LinearDimension.auto
                marginRight = LinearDimension.auto
                display = Display.flex
                flexDirection = FlexDirection.row
                flexWrap = FlexWrap.wrap
                justifyContent = JustifyContent.center
                margin(vertical = 20.px)
            }
            clothingList.forEach {
                styledDiv {
                    css {
                        height = 450.px
                        width = 200.px
                        margin(horizontal = 20.px)
                        margin(vertical = 35.px)
                    }
                    if (it.isBookmarked) {
                        styledImg {
                            css {
                                marginBottom = -50.px
                                marginRight = 25.px
                                height = 30.px
                                cursor = Cursor.pointer
                            }
                            attrs.src = "Selected_Bookmark_Icon.png"
                            attrs.onClickFunction = { _ ->
                                it.isBookmarked = false
                                dummyIndex1 += 1
                                setdummyState(dummyIndex1)
                                scope.launch {
                                    deleteClothingItemBookmark(it)
                                    setClothingList(getTopTenClothingItems())
                                }
                            }
                        }
                    }
                    else {
                        styledImg {
                            css {
                                marginBottom = -50.px
                                marginRight = 25.px
                                height = 30.px
                                cursor = Cursor.pointer
                            }
                            attrs.src = "Bookmark_Icon.png"
                            attrs.onClickFunction = { _ ->
                                dummyIndex1 += 1
                                setdummyState(dummyIndex1)
                                it.isBookmarked = true
                                scope.launch {
                                    bookmarkClothingItem(it)
                                    setClothingList(getTopTenClothingItems())
                                }
                            }
                        }
                    }
                    styledH3 {
                        css {
                            width= LinearDimension.fitContent
                            marginLeft=180.px
                            marginBottom=-25.px
                        }
                        +"$index"
                    }
                    child(
                            ListOfItems,
                            props = jsObject {
                                item = it
                            }
                    )
                    index += 1;
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
