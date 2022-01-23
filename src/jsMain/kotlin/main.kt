
import androidx.compose.runtime.Composable
import component.*
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.renderComposable
import style.AppStylesheet
import style.BaseCardStylesheet

fun main() {
    renderComposable(rootElementId = "root") {
        Style(AppStylesheet)
        KUGHeader()
        HomeView()
        KUGFooter()
    }
}


/**
 * Page Design From:
 * https://codepen.io/JavaScriptJunkie/pen/WgRBxw
 */
@Composable
private fun HomeView() = Div({
    style {
        minHeight(100.vh)
        width(100.percent)
        background("linear-gradient(120deg, #e0c3fc 0%, #8ec5fc 100%)")
        display(DisplayStyle.Flex)
        justifyContent(JustifyContent.Center)
        alignItems(AlignItems.Center)
    }
}) {
    Style(BaseCardStylesheet)
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
