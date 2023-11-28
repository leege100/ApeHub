package io.avocado.apehub.app.home.trending

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

internal object TrendingTab : Tab {
    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    override fun Content() {
        val coroutineScope = rememberCoroutineScope()
        val tabTitles = listOf("Repositories", "Developers")

        Column {
            val pagerState = rememberPagerState(
                initialPage = 0,
                initialPageOffsetFraction = 0f,
            ) { tabTitles.size }

            TabRow(
                selectedTabIndex = pagerState.currentPage,
                modifier = Modifier.width(260.dp).background(Color.Gray)
                    .align(Alignment.CenterHorizontally),
            ) {
                tabTitles.forEachIndexed { index, title ->
                    Tab(
                        selected = index == pagerState.currentPage,
                        onClick = {
                            coroutineScope.launch {
                                pagerState.scrollToPage(index)
                            }
                        },
                        modifier = Modifier.wrapContentWidth()
                    ) {
                        Spacer(Modifier.height(6.dp).width(1.dp))
                        Text(
                            text = title,
                            modifier = Modifier.height(36.dp).wrapContentWidth(),
                            textAlign = TextAlign.Center,
                            fontSize = 15.sp,
                        )
                    }
                }
            }

            HorizontalPager(pagerState) {
                when (it) {
                    0 -> Spacer( modifier = Modifier.fillMaxSize())
                    else -> Spacer( modifier = Modifier.fillMaxSize())
                }
            }
        }
    }

    @OptIn(ExperimentalResourceApi::class)
    override val options: TabOptions
        @Composable
        get() {
            val title = "Trending"
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
