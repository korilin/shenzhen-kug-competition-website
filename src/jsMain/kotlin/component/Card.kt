package component

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Div
import style.AppStylesheet

@Composable
fun Card(content: @Composable () -> Unit) = Div({
    classes(AppStylesheet.card)
}) {
    content()
}