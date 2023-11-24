import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import io.avocado.apehub.app.home.HomeScreen
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.kodein.di.compose.withDI

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {
    withDI(homeDI) {
        MaterialTheme {
            Navigator(HomeScreen)
        }
    }
}