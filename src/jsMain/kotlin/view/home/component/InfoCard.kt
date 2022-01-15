package view.home.component

import androidx.compose.runtime.Composable
import component.Card
import global.KUGInfo
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

@Composable
fun InfoCard(kugInfo: KUGInfo = KUGInfo) = Card {
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