package view.home.component

import androidx.compose.runtime.Composable
import global.KUGInfo
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import style.AppColors


@Composable
fun Banner() = Div({
    style {
        marginBottom(80.px)
    }
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

