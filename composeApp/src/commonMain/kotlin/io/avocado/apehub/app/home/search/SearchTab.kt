package io.avocado.apehub.app.home.search

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

internal object SearchTab : Tab {
    @Composable
    override fun Content() {
//        val viewModel = rememberScreenModel<AccountViewModel>()
//        val uiState by viewModel.homeUiState.collectAsState()
//        AccountPage(
//            uiState,
//            viewModel.loginOutEvent,
//            viewModel,
//        )
    }

    @OptIn(ExperimentalResourceApi::class)
    override val options: TabOptions
        @Composable
        get() {
            val title = "Search"
            val selectedIcon = painterResource("icons/tab_community_selected.png")
            val unselectedIcon = painterResource("icons/tab_community_normal.png")
            val tabNavigator = LocalTabNavigator.current.current
            return TabOptions(
                index = 3u,
                title = title,
                icon = if (tabNavigator == this) selectedIcon else unselectedIcon,
            )
        }
}
