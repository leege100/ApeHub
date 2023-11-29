package io.avocado.apehub.app.home.trending.repositories

import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.gestures.ScrollScope
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
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
import androidx.compose.ui.unit.dp
import io.avocado.apehub.common.entity.TrendingRepository
import io.avocado.apehub.core.ui.LoadableState
import io.avocado.apehub.core.ui.RefreshablePage
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

@Composable
fun TrendingRepositoriesPage(
    repositoriesUIState: LoadableState<TrendingRepositoriesUIState>,
    toastEvent: SharedFlow<String>,
    repositoriesIntent: TrendingRepositoriesIntent,
) {
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
        RefreshablePage(repositoriesUIState, repositoriesIntent::onRetry, null) { ui ->
            if (ui.repositories.isNotEmpty()) {
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

@Composable
private fun repositoryItem(repository: TrendingRepository) {
}

class CustomFlingBehavior : FlingBehavior {
    override suspend fun ScrollScope.performFling(initialVelocity: Float): Float {
        return initialVelocity * 0.1f
    }
}