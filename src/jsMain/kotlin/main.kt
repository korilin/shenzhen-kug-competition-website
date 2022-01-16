
import component.KUGFooter
import component.KUGHeader
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.renderComposable
import style.Animations
import style.AppStylesheet
import view.home.HomeView

fun main() {

    renderComposable(rootElementId = "root") {
        Style(AppStylesheet)
        Style(Animations)
        KUGHeader()
        HomeView()
        KUGFooter()
    }
}
