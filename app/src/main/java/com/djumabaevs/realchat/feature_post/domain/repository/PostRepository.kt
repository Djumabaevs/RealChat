package com.djumabaevs.realchat.feature_post.domain.repository

import com.djumabaevs.realchat.core.domain.models.Post
import kotlinx.coroutines.flow.Flow

interface PostRepository {

    val posts: Flow<PagingData<Post>>
}