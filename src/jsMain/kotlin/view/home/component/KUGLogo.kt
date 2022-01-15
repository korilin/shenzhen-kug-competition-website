package view.home.component

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.maxWidth
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.Img

@Composable
fun KUGLogo() = Img(src = "shenzhen-kug-logo.jpg", alt = "logo", attrs = {
    style {
        width(100.percent)
        maxWidth(600.px)
    }
})