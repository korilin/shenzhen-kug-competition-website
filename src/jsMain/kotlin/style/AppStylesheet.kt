package style

import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.selectors.CSSSelector


object AppStylesheet : StyleSheet() {

    init {
        "*" style {
            color(AppColors.fontColor)
        }
    }

    private const val shadow = "rgb(0 0 0 / 10%) 1px 1px 5px 0px, rgb(0 0 0 / 5%) 2px 2px 20px 5px"

    val card by style {
        padding(30.px)
        margin(5.px)
        borderRadius(20.px)
        background("#fff")
        property("box-shadow", shadow)
    }

    val homeView by style {
        marginTop(10.vh)
    }

    val homeViewCardSubTitle by style {
        textAlign(TextAlign.center)
        marginTop(20.px)
        fontWeight(600)

        fun CSSBuilder.localCommon() {
            width(30.px)
            height(2.px)
            backgroundColor(AppColors.primaryColor)
            display(DisplayStyle.InlineBlock)
            property("content", "''")
        }

        hover {
            color(AppColors.primaryColor)
        }

        before {
            localCommon()
        }

        after {
            localCommon()
        }
    }
}