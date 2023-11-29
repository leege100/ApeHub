package io.avocado.apehub.app.home.trending.repositories

import io.avocado.apehub.common.entity.TrendingRepository

interface TrendingRepositoriesIntent {
    fun onRefresh()
    fun onRetry()
    fun onItemClick(repository: TrendingRepository)
}