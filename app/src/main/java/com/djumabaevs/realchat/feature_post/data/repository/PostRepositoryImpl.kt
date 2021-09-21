package com.djumabaevs.realchat.feature_post.data.repository

import com.djumabaevs.realchat.core.domain.models.Post
import com.djumabaevs.realchat.core.util.Constants
import com.djumabaevs.realchat.feature_post.data.data_source.remote.PostApi
import com.djumabaevs.realchat.feature_post.data.paging.PostSource
import kotlinx.coroutines.flow.Flow

class PostRepositoryImpl(
    private val api: PostApi
) : PostRepository {

    override val posts: Flow<PagingData<Post>>
        get() = Pager(PagingConfig(pageSize = Constants.PAGE_SIZE_POSTS)) {
            PostSource(api)
        }.flow
}