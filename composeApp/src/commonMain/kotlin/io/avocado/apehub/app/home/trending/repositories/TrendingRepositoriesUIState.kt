package io.avocado.apehub.app.home.trending.repositories

import io.avocado.apehub.common.entity.TrendingDeveloper

data class TrendingRepositoriesUIState(
    val isPartiallyLoading: Boolean = false,
    val repositories: List<TrendingDeveloper> = listOf(),
)