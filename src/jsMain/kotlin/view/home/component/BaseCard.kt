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

    LeftCard(unChangeContent)

    Div({
        style {
            overflow("hidden")
        }
    }, infoContents[index.value])

    RightSwiper(index, infoContents.size)
}

@Composable
private fun LeftCard(unChangeContent: ContentBuilder<HTMLDivElement>) = Div({
    classes(AppStylesheet.card)
    style {
        height(250.px)
        width(250.px)
        property("box-shadow", "4px 13px 30px 1px #8ec5fc")
        property("transform", "translateX(-80px)")
    }
}, unChangeContent)

@Composable
private fun RightSwiper(index: MutableState<Int>, size: Int) = Div({
    style {
        position(Position.Absolute)
        right(20.px)
        width(11.px)
        textAlign(TextAlign.center)
    }
}) {
    repeat(size) {
        Span({
            style {
                display(DisplayStyle.InlineBlock)
                width(11.px)
                height(11.px)
                borderRadius(10.px)
                margin(8.px, 0.px)
                backgroundColor(AppColors.blueGrey)
                if (index.value == it) {
                    height(30.px)
                    backgroundColor(AppColors.primaryColor)
                }
            }
        })
    }
}