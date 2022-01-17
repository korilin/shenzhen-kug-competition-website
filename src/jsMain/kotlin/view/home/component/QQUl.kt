package view.home.component

import androidx.compose.runtime.Composable
import global.KUGInfo
import org.jetbrains.compose.web.css.margin
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Li
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.Ul

@Composable
fun QQUl(kugInfo: KUGInfo = KUGInfo) {
    Ul({
        style { margin(0.px) }
    }) {
        kugInfo.activityTypeWay.forEach {
            Li { Text("${it.key}：${it.value}") }
        }
    }
}