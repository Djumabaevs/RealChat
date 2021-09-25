package com.djumabaevs.realchat.feature_post.domain.repository

import android.net.Uri
import androidx.paging.PagingData
import com.djumabaevs.realchat.core.domain.models.Post
import com.djumabaevs.realchat.core.util.SimpleResource
import kotlinx.coroutines.flow.Flow

interface PostRepository {

    val posts: Flow<PagingData<Post>>

    suspend fun createPost(description: String, imageUri: Uri): SimpleResource
}