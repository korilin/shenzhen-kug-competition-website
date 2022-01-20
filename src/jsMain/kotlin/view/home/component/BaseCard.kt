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
import style.BaseCardStylesheet
import style.TextAlign
import kotlin.js.Date

@Composable
fun BaseCard(
    logoCardContent: ContentBuilder<HTMLDivElement>,
    infoContents: Array<ContentBuilder<HTMLDivElement>>,
) {
    val index = remember { mutableStateOf(0) }
    var time = Date()
    Div({
        classes(AppStylesheet.card, BaseCardStylesheet.baseCard)

        onWheel {
            val newTime = Date()
            if (newTime.getTime() - time.getTime() > 400) {
                index.value += if (it.deltaY >= 0) 1 else -1
                if (index.value < 0) index.value = infoContents.size - 1
                if (index.value >= infoContents.size) index.value = 0
                time = newTime
            }
        }
    }) {
        LogoCard(logoCardContent)

        Div({classes(BaseCardStylesheet.cardContentWrap) }) {
            for (i in infoContents.indices) {
                Div({
                    classes(
                        BaseCardStylesheet.cardContent,
                        if (i == index.value) BaseCardStylesheet.cardContentShow
                        else BaseCardStylesheet.cardContentHide
                    )
                }) {
                    Div({ style { width(100.percent) } }, infoContents[i])
                }
            }
        }

        RightSwiper(index, infoContents.size)
    }
}

@Composable
private fun LogoCard(unChangeContent: ContentBuilder<HTMLDivElement>) = Div({
    classes(AppStylesheet.card, BaseCardStylesheet.logoCard)
}, unChangeContent)

@Composable
private fun RightSwiper(index: MutableState<Int>, size: Int) = Div({
    style {
        position(Position.Absolute)
        right(15.px)
        width(11.px)
        textAlign(TextAlign.center)
    }
}) {
    repeat(size) { i ->
        Span({
            style {
                display(DisplayStyle.Block)
                width(11.px)
                height(11.px)
                borderRadius(10.px)
                margin(8.px, 0.px)
                backgroundColor(AppColors.lineColor)
                opacity(0.2)
                property("transition", "all 0.3s")
                if (index.value == i) {
                    height(30.px)
                    backgroundColor(AppColors.primaryColor)
                }
            }
            onClick {
                index.value = i
            }
        })
    }
}