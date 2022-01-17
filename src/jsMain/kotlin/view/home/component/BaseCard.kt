package view.home.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Span
import org.w3c.dom.HTMLDivElement
import style.AppColors
import style.AppStylesheet
import style.TextAlign

@Composable
fun BaseCard(
    unChangeContent: ContentBuilder<HTMLDivElement>,
    infoContents: Array<ContentBuilder<HTMLDivElement>>,
) = Div({
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
    val index = remember { mutableStateOf(0) }


    Div({
        style {
            overflow("hidden")
        }
    }, infoContents[index.value])

}

