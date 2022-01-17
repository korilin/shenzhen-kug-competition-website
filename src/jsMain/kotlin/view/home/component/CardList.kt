package view.home.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement
import style.AppStylesheet

@Composable
fun CardList(
    contents: Array<ContentBuilder<HTMLDivElement>>
) = Div({
    style {
        display(DisplayStyle.Flex)
        maxWidth(((contents.size - 1) * (60 + 20) + 600).px)
        property("margin", "auto")
    }
}) {
    var showItem: MutableState<Boolean>? = null

    for (index in contents.indices) {
        val show = remember { mutableStateOf(showItem == null) }
        if (showItem == null) showItem = show

        Div({
            classes(
                AppStylesheet.card,
                AppStylesheet.cardListItem,
                if (show.value) AppStylesheet.cardListItemShow else AppStylesheet.cardListItemHide
            )
            onClick {
                showItem?.value = false
                show.value = true
                showItem = show
            }
        }) {
            CardInner(contents[index], show)
        }
    }
}

@Composable
private fun CardInner(content: ContentBuilder<HTMLDivElement>, show: MutableState<Boolean>) = Div(
    {
        style {
            property("transition", "all 0.5s ease-in-out")
            position(Position.Absolute)
            padding(30.px)
            property("width", "calc(100% - 60px)")
            if (!show.value) {
                opacity(0)
            }
        }
    }, content
)

@Composable
private fun IconAndMessage() {

}