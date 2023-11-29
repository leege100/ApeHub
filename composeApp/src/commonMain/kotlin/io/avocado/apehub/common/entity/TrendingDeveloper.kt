package io.avocado.apehub.common.entity

data class TrendingDeveloper(
    val avatarUrl: String,
    val bio: String,
    val company: String,
    val createdAt: String,
    val followers: Int,
    val following: Int,
    val githubUsername: String,
    val id: Int,
    val location: String,
    val login: String,
    val name: String,
    val profileUrl: String,
    val reposUrl: String,
    val score: Int,
    val type: String,
    val url: String,
)
