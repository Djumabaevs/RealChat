package com.djumabaevs.realchat.feature_post.presentation.main_feed

data class MainFeedState(
    val isLoadingFirstTime: Boolean = true,
    val isLoadingNewPosts: Boolean = false,
)