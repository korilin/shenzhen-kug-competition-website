
import component.KUGFooter
import component.KUGHeader
import org.jetbrains.compose.web.renderComposable
import view.home.HomeView

fun main() {

    renderComposable(rootElementId = "root") {
        KUGHeader()
        HomeView()
        KUGFooter()
    }
}