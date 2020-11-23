package routings

import bigComponents.Top10Page
import react.*
import react.dom.*
import kotlinx.css.*
import react.router.dom.browserRouter
import react.router.dom.route
import react.router.dom.routeLink
import react.router.dom.switch
import styled.css
import styled.styledDiv
import styled.styledImg

//private val scope = MainScope()

val MainPageRoutes = functionalComponent<RProps> { _ ->
    browserRouter {
        styledDiv {
            css {
                display = Display.flex
                flexWrap = FlexWrap.wrap
                flexDirection = FlexDirection.rowReverse

            }
            routeLink("/") {
                    styledImg {
                        css {
                            maxHeight = 35.px
                            maxWidth = 35.px
                            padding(horizontal = 15.px)
                        }
                        attrs {
                            src = "Home_Icon.png"
                        }
                    }
            }
            routeLink("/settings") {
                styledImg {
                    css {
                        maxHeight = 35.px
                        maxWidth = 35.px
                        padding(horizontal = 15.px)
                    }
                    attrs {
                        src = "Gear_Icon.png"
                    }
                }
            }
        }

        switch {
            route("/settings") {
                div {
                    child(Top10Page)
                }
            }
            route("/") {
                div {
                    child(Top10Page)
                }
            }
        }
    }
}
//    val (clothingList, setClothingList) = useState(emptyList<ClothingListItem>())
//
//    useEffect(dependencies = listOf()) {
//        scope.launch {
//            setClothingList(getClothingList())
//        }
//    }
//
//    h1 {
//        +"Full-Stack Clothing List"
//    }
//
//    ul {
//        clothingList.sortedByDescending(ClothingListItem::priority).forEach { item ->
//            li {
//                key = item.toString()
//                +"[${item.priority}] ${item.desc}"
//                attrs.onClickFunction = {
//                    scope.launch {
//                        deleteClothingListItem(item)
//                        setClothingList(getClothingList())
//                    }
//                }
//            }
//        }
//    }

//    child(
//            InputComponent,
//            props = jsObject {
//                onSubmit = { input ->
//                    val cartItem = ClothingListItem(input.replace("!", ""), input.count { it == '!'})
//                    scope.launch {
//                        addClothingListItem(cartItem)
//                        setClothingList(getClothingList())
//                    }
//                }
//                onChange = {}
//                type = InputType.text
//            }
//    )