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
import org.w3c.dom.get
import style.AppColors
import style.AppStylesheet
import style.BaseCardStylesheet
import style.TextAlign
import kotlin.js.Date
import kotlin.math.abs

class ContentManager(
    private val contents: Array<ContentBuilder<HTMLDivElement>>, private val index: MutableState<Int>
) {
    var time = Date()

    fun onChange(isNext: Boolean) {
        val newTime = Date()
        if (newTime.getTime() - time.getTime() > 400) {
            index.value += if (isNext) 1 else -1
            if (index.value < 0) index.value = contents.size - 1
            if (index.value >= contents.size) index.value = 0
            time = newTime
        }
    }
}

@Composable
fun BaseCard(
    logoCardContent: ContentBuilder<HTMLDivElement>,
    infoContents: Array<ContentBuilder<HTMLDivElement>>,
) {
    val index = remember { mutableStateOf(0) }
    val contentManager = ContentManager(infoContents, index)
    var touchStart = 0
    var touchEnd = 0

    Div({
        classes(AppStylesheet.card, BaseCardStylesheet.baseCard)

        onWheel {
            contentManager.onChange(it.deltaY >= 0)
        }

        onTouchStart {
            touchStart = it.touches[0]!!.pageY
        }

        onTouchMove {
            touchEnd = it.touches[0]!!.pageY
            it.stopPropagation()
            it.preventDefault()
        }

        onTouchEnd {
            val change = touchStart - touchEnd
            if (abs(change) > 10) {
                contentManager.onChange(change > 0)
            }
        }

    }) {
        LogoCard(logoCardContent)

        Div({ classes(BaseCardStylesheet.cardContentWrap) }) {
            for (i in infoContents.indices) {
                Div({
                    classes(
                        BaseCardStylesheet.cardContent, if (i == index.value) BaseCardStylesheet.cardContentShow
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