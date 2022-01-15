package style

import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.Color

data class HEX(val value: String) : CSSColorValue {
    override fun toString() = value
}

fun Color.hex(value: String) = HEX(value)

object AppColors {
    val lineColor = Color.gray
    val fontColor = Color.hex("#27282c")
    val primaryColor = Color.hex("#2196f3")
}