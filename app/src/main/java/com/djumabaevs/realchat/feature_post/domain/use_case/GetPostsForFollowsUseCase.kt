package com.djumabaevs.realchat.feature_post.domain.use_case

import androidx.paging.PagingData
import com.djumabaevs.realchat.core.domain.models.Post
import com.djumabaevs.realchat.feature_post.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow

class GetPostsForFollowsUseCase(
    private val repository: PostRepository
) {

    operator fun invoke(): Flow<PagingData<Post>> {
        return repository.posts
    }
}