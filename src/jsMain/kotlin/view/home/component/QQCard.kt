package view.home.component

import androidx.compose.runtime.Composable
import global.KUGInfo
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Li
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.Ul
import style.AppStylesheet

@Composable
fun QQCard(kugInfo: KUGInfo = KUGInfo) = Div({
    classes(AppStylesheet.card)
}) {
    Ul {
        kugInfo.activityTypeWay.forEach {
            Li { Text("${it.key}：${it.value}") }
        }
    }
}