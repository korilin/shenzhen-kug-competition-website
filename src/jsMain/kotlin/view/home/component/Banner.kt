package view.home.component

import androidx.compose.runtime.Composable
import global.KUGInfo
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.Text
import style.AppColors
import style.AppStylesheet.style
import style.TextAlign

@Composable
fun Banner() = Div({
    style {
        marginTop(80.px)
        marginBottom(80.px)
        textAlign(TextAlign.center)
}) {
    H1({
        style {
            fontSize(55.px)
            marginBottom(0.px)
            color(AppColors.primaryColor)
        }
    }) { Text(KUGInfo.title) }
    H2({
        style {
            marginTop(15.px)
            fontSize(36.px)
        }
    }) { Text(KUGInfo.subTitle) }
}

