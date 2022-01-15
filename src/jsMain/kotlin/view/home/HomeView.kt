package view.home

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.Picture
import view.home.component.InfoCard
import view.home.component.KUGLogo

@Composable
fun HomeView() = Div({
    classes("home-wrap")
}) {
    Div({
        style {
            display(DisplayStyle.Flex)
            justifyContent(JustifyContent.Center)
            alignItems(AlignItems.Center)
            flexWrap(FlexWrap.Wrap)
        }
    }) {
        Div({
            style {
                width(400.px)
                textAlign(AlignContent.Center.value)
            }
        }) {
            KUGLogo()
        }
        Div({
            style {
                marginTop(50.px)
                width(40.percent)
                minWidth(350.px)
            }
        }) {
            InfoCard()
        }
    }
}