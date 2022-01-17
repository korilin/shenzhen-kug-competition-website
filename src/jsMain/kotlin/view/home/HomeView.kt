package view.home

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.AttrsBuilder
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement
import style.Animations
import style.AppStylesheet
import style.TextAlign

private fun AttrsBuilder<HTMLDivElement>.entryAnimation(delay: CSSSizeValue<out CSSUnitTime>) = style {
    position(Position.Relative)
    opacity(0)
    animation(Animations.bannerEnterKeyframe) {
        duration(1.0.s)
        delay(delay)
        iterationCount()
        fillMode(AnimationFillMode.Forwards)
    }
}

private interface CardAdapter {

}

@Composable
private fun CardAdapter() {

}

/**
 * Page Design From:
 * https://codepen.io/JavaScriptJunkie/pen/WgRBxw
 */
@Composable
fun HomeView() = Div({
    style {
        minHeight(100.vh)
        minWidth(100.vw)
        background("linear-gradient(120deg, #e0c3fc 0%, #8ec5fc 100%)")
        display(DisplayStyle.Flex)
        justifyContent(JustifyContent.Center)
        alignItems(AlignItems.Center)
    }
}) {
    BaseCard()
}

@Composable
fun BaseCard() = Div({
    classes(AppStylesheet.card)
    style {
        height(400.px)
        width(90.percent)
        maxWidth(850.px)
        position(Position.Relative)
        display(DisplayStyle.Flex)
        padding(20.px)
        alignItems(AlignItems.Center)
    }
}) {
    Div({
        classes(AppStylesheet.card)
        style {
            height(300.px)
            width(300.px)
            property("box-shadow", "4px 13px 30px 1px #8ec5fc")
            property("transform", "translateX(-80px)")
        }
    }) {

    }
    Div({
        style {
            backgroundColor(Color.white)
        }
    }) {

    }
    Div({
        style {
            position(Position.Absolute)
            right(20.px)
            width(15.px)
            textAlign(TextAlign.center)

        }
    }){
        
    }
}