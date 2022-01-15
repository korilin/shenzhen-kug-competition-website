package view.home.component

import androidx.compose.runtime.Composable
import global.KUGInfo
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Li
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.Ul

@Composable
fun InfoCard(kugInfo: KUGInfo) = Div({
    style {
        padding(20.px)
        margin(10.px)
        borderRadius(20.px)
        background("#fff")
    }
}) {
    Div({
        classes( )
        style { marginBottom(20.px) }
    }) { Text(kugInfo.description) }
    Div({}) {
        Text("活动方式：")
        Ul {
            kugInfo.activityTypeWay.forEach {
                Li { Text("${it.key}：${it.value}") }
            }
        }
    }
}