package view.home

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.AttrsBuilder
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement
import style.Animations
import style.AppStylesheet
import style.TextAlign
import view.home.component.InfoCard
import view.home.component.KUGLogo
import view.home.component.Banner

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

@Composable
fun HomeView() = Div({
    classes(AppStylesheet.homeView)
}) {
    Banner()
    KUGLogoAndInfo()
}


@Composable
private fun KUGLogoAndInfo() = Div({
    style {
        display(DisplayStyle.Flex)
        justifyContent(JustifyContent.Center)
        alignItems(AlignItems.Center)
        flexWrap(FlexWrap.Wrap)
    }
}) {
    Div({
        style {
            width(40.percent)
            maxWidth(450.px)
            minWidth(400.px)
            textAlign(TextAlign.center)
        }
    }) {
        KUGLogo()
    }
    Div({
        style {
            marginTop(20.px)
            marginLeft(20.px)
            minWidth(800.px)
            width(60.percent)
        }
    }) {
        InfoCard()
    }
}