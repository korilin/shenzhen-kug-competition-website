package view.home

import androidx.compose.runtime.Composable
import global.KUGInfo
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.Text
import style.TextAlign
import view.home.component.InfoCard
import view.home.component.KUGLogo

@Composable
fun HomeView() = Div({
    classes("home-wrap")
}) {
    Title()
    KUGLogoAndInfo()
}

@Composable
private fun Title() = Div({
    style {
        marginTop(80.px)
        marginBottom(80.px)
        textAlign(TextAlign.center)
    }
}) {
    H1({
        style {
            fontSize(55.px)
            marginBottom(0.px)
        }
    }) { Text(KUGInfo.title) }
    H2({
        style {
            marginTop(15.px)
            fontSize(36.px)
        }
    }) { Text(KUGInfo.subTitle) }
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