package style

import org.jetbrains.compose.web.css.*


object AppStylesheet : StyleSheet() {

    init {
        "*" style {
            color(AppColors.fontColor)
        }
        "body" style {
            margin(0.px)
            padding(0.px)
        }
    }

    private const val shadow = "rgb(0 0 0 / 10%) 1px 1px 5px 0px, rgb(0 0 0 / 5%) 2px 2px 20px 5px"

    val card by style {
        className("common-card")
        padding(30.px)
        borderRadius(20.px)
        background("#fff")
        property("box-shadow", shadow)
    }

    val homeView by style {
        className("home-view")
        marginTop(10.vh)
    }

    val cardListItem by style {
        className("home-card-list-item")
        borderRadius(30.px)
        minHeight(300.px)
        property("transition", "all 0.8s ease-in-out")
        margin(10.px)
        padding(0.px)
        overflow("hidden")
        position(Position.Relative)
    }

    val cardListItemShow by style {
        className("home-card-list-item-show")
        flexGrow(1)
    }

    val cardListItemHide by style {
        className("home-card-list-item-hide")
        width(60.px)
        minWidth(60.px)
    }
}