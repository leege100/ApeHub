package io.avocado.apehub.common.entity

data class TrendingRepository(
    val name: String,
    val description: String,
    val language: String,
    val stars: Int,
    val forks: Int,
    val watchers: Int,
    val url: String,
    val owner: RepositoryOwner,
    val createdAt: String,
    val updatedAt: String,
    val pushedAt: String,
    val homepage: String,
    val size: Int,
    val defaultBranch: String,
    val openIssues: Int,
    val license: RepositoryLicense,
)

data class RepositoryOwner(
    val login: String,
    val id: Int,
    val node_id: String,
    val avatar_url: String,
    val gravatar_id: String,
    val url: String,
    val html_url: String,
    val followers_url: String,
    val following_url: String,
    val gists_url: String,
    val starred_url: String,
    val subscriptions_url: String,
    val organizations_url: String,
)

data class RepositoryLicense(
    val key: String,
    val name: String,
    val spdx_id: String,
    val url: String,
    val node_id: String,
)
