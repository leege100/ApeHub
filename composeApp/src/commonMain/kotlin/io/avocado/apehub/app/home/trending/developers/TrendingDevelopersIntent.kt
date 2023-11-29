package io.avocado.apehub.app.home.trending.developers

import io.avocado.apehub.common.entity.TrendingDeveloper

interface TrendingDevelopersIntent{
    fun onRefresh()
    fun onRetry()
    fun onItemClicked(developer: TrendingDeveloper)
}
