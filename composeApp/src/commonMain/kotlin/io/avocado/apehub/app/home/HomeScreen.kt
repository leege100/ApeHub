package io.avocado.apehub.app.home

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import io.avocado.apehub.app.home.HomePage

object HomeScreen : Screen {
    @Composable
    override fun Content() {
        HomePage()
    }
}
