package io.avocado.apehub.app.home.trending.developers

import io.avocado.apehub.common.entity.TrendingDeveloper

data class TrendingDevelopersUIState (
    val isPartiallyLoading: Boolean = false,
    val developers: List<TrendingDeveloper> = listOf(),
)