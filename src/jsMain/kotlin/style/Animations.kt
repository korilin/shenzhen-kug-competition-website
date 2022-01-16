package style

import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.opacity
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.top

object Animations : StyleSheet() {

    val bannerEnterKeyframe by keyframes {
        from {
            opacity(0)
            top(20.px)
        }
        to {
            opacity(1)
            top(0.px)
        }
    }

}
