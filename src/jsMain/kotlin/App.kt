import react.*
import react.dom.*
import kotlinext.js.*
import kotlinx.html.js.*
import kotlinx.coroutines.*

private val scope = MainScope()

val App = functionalComponent<RProps> { _ ->
    val (clothingList, setClothingList) = useState(emptyList<ClothingListItem>())

    useEffect(dependencies = listOf()) {
        scope.launch {
            setClothingList(getClothingList())
        }
    }

    h1 {
        +"Full-Stack Clothing List"
    }
    ul {
        clothingList.sortedByDescending(ClothingListItem::priority).forEach { item ->
            li {
                key = item.toString()
                +"[${item.priority}] ${item.desc}"
                attrs.onClickFunction = {
                    scope.launch {
                        deleteClothingListItem(item)
                        setClothingList(getClothingList())
                    }
                }
            }
        }
    }

    child(
        InputComponent,
        props = jsObject {
            onSubmit = { input ->
                val cartItem = ClothingListItem(input.replace("!", ""), input.count { it == '!'})
                scope.launch {
                    addClothingListItem(cartItem)
                    setClothingList(getClothingList())
                }
            }
        }
    )
}