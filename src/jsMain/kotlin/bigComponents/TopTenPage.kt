package bigComponents

import ClothingItem
import getClothingList
import react.*
import kotlinext.js.*
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.css.*
import smallComponents.ListOfItems
import styled.css
import styled.styledDiv
private val scope = MainScope()
data class ClothingList(val name:String, val price:Int, val imageLink:String, val siteLink:String)


val Top10Page = functionalComponent<RProps> { _ ->
    val (clothingList, setClothingList) = useState(emptyList<ClothingItem>())

    useEffect(dependencies = listOf()) {
        scope.launch {
            setClothingList(getClothingList())
        }
    }

    styledDiv {
        css {
            display = Display.flex
            flexWrap = FlexWrap.wrap        //For smaller devices, it will move the cards on different lines
        }

        clothingList.forEach { temp ->
            child(
                ListOfItems,
                props = jsObject {
                    item = temp
                }
            )
        }
    }
}
