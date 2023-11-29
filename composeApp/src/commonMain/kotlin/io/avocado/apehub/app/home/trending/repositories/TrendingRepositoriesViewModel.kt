package io.avocado.apehub.app.home.trending.repositories

import cafe.adriel.voyager.core.model.ScreenModel
import io.avocado.apehub.common.entity.TrendingRepository
import io.avocado.apehub.core.ui.LoadableState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow

class TrendingRepositoriesViewModel: ScreenModel, TrendingRepositoriesIntent {

    private val _uiState = MutableStateFlow(LoadableState(data = TrendingRepositoriesUIState()))
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

    override fun onItemClick(repository: TrendingRepository) {

    }
}