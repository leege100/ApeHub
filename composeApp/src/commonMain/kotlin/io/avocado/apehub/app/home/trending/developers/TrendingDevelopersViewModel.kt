package io.avocado.apehub.app.home.trending.developers

import cafe.adriel.voyager.core.model.ScreenModel
import io.avocado.apehub.common.entity.TrendingDeveloper
import io.avocado.apehub.core.ui.LoadableState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow

class TrendingDevelopersViewModel: ScreenModel, TrendingDevelopersIntent {

    private val _uiState = MutableStateFlow(LoadableState(data = TrendingDevelopersUIState()))
    val uiState = _uiState.asStateFlow()

    private val _toastEvent = MutableSharedFlow<String>()
    val toastEvent = _toastEvent.asSharedFlow()

    init {
        onRefresh()
    }
    override fun onRefresh() {

    }

    override fun onRetry() {

    }

    override fun onItemClicked(developer: TrendingDeveloper) {

    }
}