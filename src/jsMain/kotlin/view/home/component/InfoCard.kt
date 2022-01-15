package view.home.component

import androidx.compose.runtime.Composable
import global.KUGInfo
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import style.AppStylesheet

@Composable
fun InfoCard(kugInfo: KUGInfo = KUGInfo) = Div({
    classes(AppStylesheet.card)
    style { padding(30.px) }
}) {
    Div({
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