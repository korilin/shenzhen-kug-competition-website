package style

import org.jetbrains.compose.web.css.*


object AppStylesheet : StyleSheet() {
    val card by style {
        padding(20.px)
        margin(10.px)
        border {
            width = 1.px
            style = LineStyle.Solid
            color = AppColors.lineColor
        }
        borderRadius(20.px)
        background("#fff")
    }
}