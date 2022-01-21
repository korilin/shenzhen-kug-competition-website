package style

import org.jetbrains.compose.web.css.*


object AppStylesheet : StyleSheet() {

    init {
        "*" style {
            color(AppColors.fontColor)
            fontFamily("Fira Sans")
        }
        "body" style {
            margin(0.px)
            padding(0.px)
            minHeight(100.vh)
            width(100.vw)
            position(Position.Relative)
        }
        "root" style {
            position(Position.Relative)
        }
    }

    val card by style {
        className("common-card")
        padding(30.px)
        borderRadius(20.px)
        background("#fff")
        property("box-shadow", "rgb(0 0 0 / 10%) 1px 1px 5px 0px, rgb(0 0 0 / 5%) 2px 2px 20px 5px")
    }

    val buttonGroupItem by style {
        borderRadius(30.px)
        color(Color.white)
        width(100.percent)
        border(0.px)
        flexGrow(1)
        display(DisplayStyle.InlineBlock)
        padding(8.px, 24.px)
        fontSize(13.px)
        fontWeight(500)
        lineHeight("1.3")
        marginTop(20.px)
        backgroundColor(AppColors.primaryColor)
        property("transition", "all 150ms linear")
        cursor("pointer")
        property("box-shadow", "2px 5px 10px #e4e4e4")

        self + hover style {
            opacity(0.85)
        }
        self + active style {
            opacity(0.7)
        }
    }
}