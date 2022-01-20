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
                padding(40.px)
                paddingBottom(50.px)
            }
        }
    }

    val logoCard by style {
        property("box-shadow", "4px 13px 30px 1px #8ec5fc")
        property("transform", "translateX(-80px)")
        property("transition", "all 0.3s")
        height(250.px)
        width(250.px)

        media(mediaMaxWidth(1100.px)) {
            self style {
                property("transform", "translateX(-70px)")
            }
        }

        media(mediaMaxWidth(800.px)) {
            self style {
                property("transform", "translateY(-180px)")
            }
        }

        media(mediaMaxWidth(600.px)) {
            self style {
                height(200.px)
                width(200.px)
                property("transform", "translateY(-120px)")
            }
        }
    }

    val cardContent by style {
        property("transition", "all 0.3s linear")
        position(Position.Absolute)
        width(100.percent)
        display(DisplayStyle.Flex)
        alignItems(AlignItems.Center)
        opacity(1)
        property("visibility", "visible")
        top(0.px)

        media(mediaMaxWidth(800.px)) {
            self style {
                marginTop((-120).px)
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