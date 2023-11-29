package io.avocado.apehub.app.home.trending.developers

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import io.avocado.apehub.app.home.trending.repositories.CustomFlingBehavior
import io.avocado.apehub.core.ui.LoadableState
import io.avocado.apehub.core.ui.RefreshablePage
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

@Composable
fun TrendingDevelopersPage(
    uiState: LoadableState<TrendingDevelopersUIState>,
    toastEvent: SharedFlow<String>,
    developersIntent: TrendingDevelopersIntent) {
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    val state = rememberLazyListState()

    LaunchedEffect(toastEvent) {
        toastEvent.collect {
            scope.launch {
                snackbarHostState.showSnackbar(it)
            }
        }
    }
    Scaffold(snackbarHost = { SnackbarHost(snackbarHostState) }) {
        RefreshablePage(uiState, developersIntent::onRetry, null) { ui ->
            if (ui.developers.isNotEmpty()) {
                LazyColumn(state = state, modifier = Modifier.fillMaxSize(), flingBehavior = CustomFlingBehavior()) {
                }
            } else {
                Text(
                    modifier = Modifier.fillMaxSize(),
                    text = "没有数据",
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}