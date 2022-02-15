package component

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import style.AppColors
import style.TextAlign
import style.hex

@Composable
fun KUGFooter() = Div({
    style {
        position(Position.Absolute)
        height(60.px)
        width(90.percent)
        bottom(0.px)
        property("z-index", "100")
        display(DisplayStyle.Flex)
        alignItems(AlignItems.Center)
        textAlign(TextAlign.center)
        marginLeft(5.percent)
        marginRight(5.percent)
    }
}) {
    Div({
        style {
            backgroundColor(Color.hex("ffffff59"))
            padding(8.px, 24.px)
            property("margin", "auto")
            borderRadius(20.px)
            fontSize(12.px)
        }
    }) {
        val link = "https://codepen.io/JavaScriptJunkie/pen/WgRBxw"
        Text("This page style design comes from: ")
        A(href = link, attrs = {
            style {
                color(AppColors.primaryColor)
            }
        }) {
            Text(link)
        }
    }
}