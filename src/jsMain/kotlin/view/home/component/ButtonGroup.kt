package view.home.component

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

@Composable
fun ButtonGroup() {
    Div {
        Button({
            onClick { }
        }) {
            Text("Kotlin Seminar")
        }
    }
    Div {
        Button({
            onClick { }
        }) {
            Text("Kotlin Seminar")
        }
    }
    Div {
        Button({
            onClick { }
        }) {
            Text("Kotlin Seminar")
        }
    }
}