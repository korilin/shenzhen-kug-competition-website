package view.home.component

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.Img

@Composable
fun KUGLogo() = Img(src = "shenzhen-kug-logo.jpg", alt = "logo", attrs = {
    style {
        width(300.px)
    }
})