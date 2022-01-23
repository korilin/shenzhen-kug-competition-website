package component


import androidx.compose.runtime.Composable
import KUGInfo
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import style.AppColors


@Composable
fun KUGBanner() {
    H1({
        style {
            fontSize(32.px)
            marginBottom(0.px)
        }
    }) { Text(KUGInfo.title) }
    P({
        style {
            fontSize(14.px)
            marginTop(8.px)
            marginBottom(20.px)
            color(AppColors.secondFontColor)
        }
    }) {
        Text("组建于：${KUGInfo.date}")
    }
    H2({
        style {
            fontSize(18.px)
            fontWeight(500)
        }
    }) { Text(KUGInfo.subTitle) }
}