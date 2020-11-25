package bigComponents

import ClothingItem
import OutfitWithClothes
import bookmarkRandomizedOutfit
import getClothingList
import getRandomizedOutfit
import react.*
import kotlinext.js.*
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.css.*
import kotlinx.html.js.onClickFunction
import smallComponents.ListOfItems
import smallComponents.OutfitCard
import styled.css
import styled.styledButton
import styled.styledDiv
private val scope = MainScope()

val HomePage = functionalComponent<RProps> { _ ->
    val (randomBookmark, setRandomBookmark) = useState<OutfitWithClothes?>(null)

    useEffect(dependencies = listOf()) {
        scope.launch {
            setRandomBookmark(getRandomizedOutfit())
        }
    }

    styledDiv {
        css {
            width = 300.px
            height = 450.px
        }
        if (randomBookmark != null) {
            child (
                OutfitCard,
                props = jsObject {
                    item = randomBookmark
                }
            )
        }

        styledButton {
            css {
                height = 20.px
                width = LinearDimension.auto
            }
            attrs.onClickFunction = {
                scope.launch {
                    bookmarkRandomizedOutfit(randomBookmark!!)
                }
            }
            +"Bookmark Outfit"
        }
    }
}
