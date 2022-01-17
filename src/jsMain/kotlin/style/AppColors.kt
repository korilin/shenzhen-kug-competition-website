package style

import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.Color

data class HEX(val value: String) : CSSColorValue {
    override fun toString() = value
}

fun Color.hex(value: String) = HEX(if (value[0] == '#') value else "#$value")

object AppColors {
    val lineColor = Color.gray
    val fontColor = Color.hex("27282c")
    val primaryColor = Color.hex("2196f3")


    val red = Color.hex("f44336")
    val indigo = Color.hex("3f51b5")
    val teal = Color.hex("009688")
    val blueGrey = Color.hex("607d8b")
}