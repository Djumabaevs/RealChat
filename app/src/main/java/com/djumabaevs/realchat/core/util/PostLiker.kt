package com.djumabaevs.realchat.core.util

import com.djumabaevs.realchat.core.domain.models.Post

interface PostLiker {

    suspend fun toggleLike(
        posts: List<Post>,
        parentId: String,
        onRequest: suspend (isLiked: Boolean) -> SimpleResource,
        onStateUpdated: (List<Post>) -> Unit
    )
}