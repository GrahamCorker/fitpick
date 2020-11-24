package smallComponents

import OutfitWithClothes
import kotlinx.css.*
import react.RProps
import react.dom.a
import react.dom.h1
import react.dom.head
import react.dom.img
import react.functionalComponent
import react.useState
import styled.*
import kotlin.math.roundToInt
import kotlin.math.roundToLong
import kotlin.math.round

external interface OutfitProp : RProps {
    var item:OutfitWithClothes
}


val OutfitCard = functionalComponent<OutfitProp> { props ->
    var price:Double = 0.0
    console.log(props.item)
    styledDiv {
        css {
            width = 250.px
            height = 400.px
            borderStyle = BorderStyle.solid
            borderWidth = 3.px
            display = Display.flex
            flexDirection = FlexDirection.row
        }

        styledDiv{
            css{
                height = 100.pct
                width = 50.pct
                display = Display.flex
                flexDirection = FlexDirection.column
                alignItems = Align.center
                justifyContent = JustifyContent.center
            }

            if (props.item.headWear != null) {
                styledImg {
                    css {
                        height = 20.pct
                    }
                    attrs.src = props.item.headWear!!.img
                }
                styledA {
                    css{
                        marginTop = 5.px
                        marginBottom = 20.px
                    }
                    +"$${props.item.headWear!!.price}"
                    attrs.href = props.item.headWear!!.siteLink
                }
                price = (price + props.item.headWear!!.price)
            }

            if (props.item.midSection != null) {
                styledImg {
                    css {
                        height = 20.pct
                    }
                    attrs.src = props.item.midSection!!.img
                }
                styledA {
                    css{
                        marginTop = 5.px
                        marginBottom = 20.px
                    }
                    +"$${props.item.midSection!!.price}"
                    attrs.href = props.item.midSection!!.siteLink
                }
                price =(price + props.item.midSection!!.price)
            }

            if (props.item.lowerSection != null) {
                styledImg {
                    css {
                        height = 20.pct
                    }
                    attrs.src = props.item.lowerSection!!.img
                }
                styledA {
                    css{
                        marginTop = 5.px
                        marginBottom = 20.px
                    }
                    +"$${props.item.lowerSection!!.price}"
                    attrs.href = props.item.lowerSection!!.siteLink
                }
                price = (price + props.item.lowerSection!!.price)
            }
        }

        styledDiv {
            css {
                height = 100.pct
                width = 50.pct
                display = Display.flex
                flexDirection = FlexDirection.column
                alignItems = Align.center
                justifyContent = JustifyContent.center
            }
            if (props.item.footWear != null) {
                styledImg {
                    css {
                        height = 20.pct
                    }
                    attrs.src = props.item.footWear!!.img
                }
                styledA {
                    css{
                        marginBottom = 20.px
                        marginTop = 5.px
                    }
                    +"$${props.item.footWear!!.price}"
                    attrs.href = props.item.footWear!!.siteLink
                }
                price = (price + props.item.footWear!!.price)
            }

            if (props.item.accessory != null) {
                styledImg {
                    css {
                        height = 20.pct
                    }
                    attrs.src = props.item.accessory!!.img
                }
                styledA {
                    css{
                        marginTop = 5.px
                        marginBottom = 20.px
                    }
                    +"$${props.item.accessory!!.price}"
                    attrs.href = props.item.accessory!!.siteLink
                }
                price = (price + props.item.accessory!!.price)
            }


            styledH2{
                +"$${round(price)}"
            }
        }
    }
}
