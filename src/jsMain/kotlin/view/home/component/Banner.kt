package view.home.component

import androidx.compose.runtime.Composable
import global.KUGInfo
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import style.AppColors


@Composable
fun Banner() {
    H1({
        style {
            fontSize(42.px)
            marginBottom(0.px)
            color(AppColors.primaryColor)
        }
    }) { Text(KUGInfo.title) }
    H2({
        style {
            marginTop(15.px)
            fontSize(24.px)
            fontWeight(500)
        }
    }) { Text(KUGInfo.subTitle) }
}

