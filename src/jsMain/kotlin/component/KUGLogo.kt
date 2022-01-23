package component

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Img

@Composable
fun KUGLogo() = Img(src = "shenzhen-kug-logo.jpg", alt = "logo", attrs = {
    style {
        height(100.percent)
        maxWidth(250.px)
    }
})