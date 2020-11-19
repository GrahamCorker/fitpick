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


val dummyListOfClothing = listOf<ClothingList>(
    ClothingList("Shirt", 10, "https://static.zara.cn/photos///2020/I/0/2/p/0679/303/800/2/w/1920/0679303800_6_1_1.jpg?ts=1595240666151", "https://www.amazon.com"),
    ClothingList("Pants", 12, "https://www.blackdiamondequipment.com/on/demandware.static/-/Sites-bdel/default/dw8cdb3fd5/products/S18_Product_Images/Apparel/HU53_015_Black_W_SharpEndPants_Front.jpg", "https://www.amazon.com/"),
    ClothingList("Shirt2", 8, "https://static.zara.cn/photos///2020/I/0/2/p/0679/303/800/2/w/1920/0679303800_6_1_1.jpg?ts=1595240666151", "https://www.amazon.com/"),
    ClothingList("Shirt3", 5, "https://static.zara.cn/photos///2020/I/0/2/p/0679/303/800/2/w/1920/0679303800_6_1_1.jpg?ts=1595240666151", "https://www.amazon.com/"),
)

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
