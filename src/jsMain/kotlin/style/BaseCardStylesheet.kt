package style

import org.jetbrains.compose.web.css.*

object BaseCardStylesheet : StyleSheet() {
    val baseCard by style {
        height(400.px)
        width(80.percent)
        position(Position.Relative)
        display(DisplayStyle.Flex)
        padding(20.px)
        paddingRight(50.px)
        alignItems(AlignItems.Center)
        property("transition", "all 0.3s")

        maxWidth(850.px)

        media(mediaMaxWidth(1100.px)) {
            self style {
                maxWidth(700.px)
                height(430.px)
            }
        }

        media(mediaMaxWidth(950.px)) {
            self style {
                maxWidth(600.px)
                height(450.px)
            }
        }

        media(mediaMaxWidth(800.px)) {
            self style {
                flexDirection(FlexDirection.Column)
                padding(50.px)
                paddingBottom(0.px)
                marginTop(150.px)
                marginBottom(100.px)
            }
        }

        media(mediaMaxWidth(650.px)) {
            self style {
                property("width","calc(90% - 100px)")
            }
        }
    }

    val logoCard by style {
        property("box-shadow", "4px 13px 30px 1px #8ec5fc")
        property("transform", "translateX(-80px)")
        property("transition", "all 0.3s")
        height(250.px)
        width(250.px)
        minWidth(200.px)
        textAlign(TextAlign.center)

        media(mediaMaxWidth(950.px)) {
            self style {
                height(180.px)
                width(180.px)
            }
        }

        media(mediaMaxWidth(800.px)) {
            self style {
                width(75.percent)
                height(300.px)
                property("transform", "translateY(-60%)")
            }
        }

        media(mediaMaxWidth(600.px)) {
            self style {
                height(200.px)
            }
        }
    }

    val cardContentWrap by style {
        position(Position.Relative)
        height(100.percent)
        flexGrow(1)
        media(mediaMaxWidth(800.px)) {
            self style {
                width(100.percent)
            }
        }
    }

    val cardContent by style {
        property("transition", "all 0.3s linear")
        position(Position.Absolute)
        height(100.percent)
        width(100.percent)
        display(DisplayStyle.Flex)
        alignItems(AlignItems.Center)
        opacity(1)
        property("visibility", "visible")
        top(0.px)

        media(mediaMaxWidth(800.px)) {
            self style {
                marginTop((-100).px)
            }
        }
    }

    val cardContentShow by style {
        opacity(1)
        property("visibility", "visible")
        top(0.px)
        property("transition-delay", "0.3s")
    }

    val cardContentHide by style {
        opacity(0)
        property("visibility", "hidden")
        top(30.px)
    }
}