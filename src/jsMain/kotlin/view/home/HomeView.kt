package view.home

import androidx.compose.runtime.Composable
import global.KUGInfo
import org.jetbrains.compose.web.attributes.AttrsBuilder
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLDivElement
import style.Animations
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
    BaseCard({ KUGLogo() }, arrayOf(
        { KUGBanner() },
        { Text(KUGInfo.description) },
        {
            KUGInfo.qqGroup.lines().forEach {
                Div { Text(it) }
            }
        },
        { ButtonGroup() }
    ))
}

