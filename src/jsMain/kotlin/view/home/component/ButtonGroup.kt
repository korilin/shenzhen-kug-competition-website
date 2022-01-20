package view.home.component

import androidx.compose.runtime.Composable
import global.KUGInfo
import kotlinx.browser.window
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import style.AppColors
import style.AppStylesheet
import style.TextAlign

@Composable
fun ButtonGroup() = Div({
    style {
        textAlign(TextAlign.center)
    }
}) {
    H3 { Text("- more -") }
    Button({
        onClick { window.open("https://seminar.shenzhen-kug.cn/") }
        classes(AppStylesheet.button)
    }) {
        Text("研讨会（Kotlin Seminar）")
    }
    Button({
        onClick { window.open("https://discuss.kotliner.cn/") }
        classes(AppStylesheet.button)
        style { backgroundColor(AppColors.indigo) }
    }) {
        Text("讨论社区")
    }
    Button({
        onClick { window.open(KUGInfo.github) }
        classes(AppStylesheet.button)
        style { backgroundColor(AppColors.dark) }
    }) {
        Text("Organization GitHub")
    }
}
