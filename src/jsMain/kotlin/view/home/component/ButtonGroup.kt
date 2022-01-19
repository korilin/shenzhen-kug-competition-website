package view.home.component

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import style.AppColors
import style.AppStylesheet
import style.TextAlign

@Composable
fun ButtonGroup() = Div({
    style {
        textAlign(TextAlign.center)
    }
}) {
    H3({ style { color(AppColors.primaryColor) } }) { Text("- more -") }
    Button({
        onClick { println("hi") }
        classes(AppStylesheet.button)
    }) {
        Text("Kotlin Seminar")
    }
    Button({
        onClick { }
        classes(AppStylesheet.button)
    }) {
        Text("Kotlin Seminar")
    }
    Button({
        onClick { }
        classes(AppStylesheet.button)
    }) {
        Text("Kotlin Seminar")
    }
}
