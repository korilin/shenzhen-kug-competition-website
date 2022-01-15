package style

import org.jetbrains.compose.web.css.*


object AppStylesheet : StyleSheet() {

    init {
        "*" style {
            color(AppColors.fontColor)
        }
    }

    private const val shadow = "rgb(0 0 0 / 10%) 1px 1px 5px 0px, rgb(0 0 0 / 5%) 2px 2px 20px 5px"

    val card by style {
        padding(24.px, 20.px)
        margin(5.px)
        borderRadius(20.px)
        background("#fff")
        property("box-shadow", shadow)
    }
}