package view.home

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import style.TextAlign
import view.home.component.InfoCard
import view.home.component.KUGLogo
import view.home.component.Banner

@Composable
fun HomeView() = Div({
    classes("home-wrap")
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
            maxWidth(800.px)
            width(80.percent)
        }
    }) {
        InfoCard()
    }
}