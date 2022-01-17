package view.home

import androidx.compose.runtime.Composable
import global.KUGInfo
import org.jetbrains.compose.web.attributes.AttrsBuilder
import org.jetbrains.compose.web.attributes.DirType
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLParagraphElement
import style.Animations
import style.Animations.hover
import style.AppStylesheet
import style.TextAlign
import view.home.component.*

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
    Div({
        entryAnimation(0.3.s)
    }) {
        LogoAndBanner()
    }
    Div({
        entryAnimation(0.6.s)
        style {
            property("margin", "auto")
            marginTop(10.vh)
            maxWidth(80.percent)
        }
    }) {
        CardList(arrayOf(
            { Text(KUGInfo.description) },
            { QQUl() },
            { Buttons() }
        ))
    }
}


@Composable
private fun LogoAndBanner() = Div({
    style {
        display(DisplayStyle.Flex)
        justifyContent(JustifyContent.Center)
        alignItems(AlignItems.Center)
        flexWrap(FlexWrap.Wrap)
    }
}) {
    Div({
        style {
            width(300.px)
            paddingRight(20.px)
            paddingLeft(20.px)
            textAlign(TextAlign.left)
        }
    }) {
        KUGLogo()
    }
    Div({
        style {
            width(67.percent)
            marginTop(20.px)
            minWidth(300.px)
            maxWidth(800.px)
        }
    }) {
        Banner()
    }
}
