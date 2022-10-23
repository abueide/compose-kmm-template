import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.dialexa.mnp.app.ComposeApp
import com.dialexa.mnp.compose.components.shared.main.MainComponent
import com.dialexa.mnp.compose.theme.AppTheme

val app = ComposeApp()
val mainComponent = MainComponent()

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        AppTheme {
            mainComponent.view()
        }
    }
}
