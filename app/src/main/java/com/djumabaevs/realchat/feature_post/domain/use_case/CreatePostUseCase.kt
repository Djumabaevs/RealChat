package com.djumabaevs.realchat.feature_post.domain.use_case

import android.net.Uri
import com.djumabaevs.realchat.core.util.SimpleResource
import com.djumabaevs.realchat.feature_post.domain.repository.PostRepository

class CreatePostUseCase(
    private val repository: PostRepository
) {

    suspend operator fun invoke(
        description: String,
        imageUri: Uri
    ): SimpleResource {
        return repository.createPost(description, imageUri)
    }
}