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
        padding(30.px)
        margin(5.px)
        borderRadius(20.px)
        background("#fff")
        property("box-shadow", shadow)
    }

    val homeView by style {
        marginTop(10.vh)
    }

    val cardListItem by style {
        borderRadius(30.px)
        minHeight(300.px)
        property("transition", "all 0.8s ease-in-out")
        margin(10.px)
        padding(0.px)
        overflow("hidden")
        position(Position.Relative)
    }

    val cardListItemShow by style {
        flexGrow(1)
    }

    val cardListItemHide by style {
        width(60.px)
        minWidth(60.px)
    }
}