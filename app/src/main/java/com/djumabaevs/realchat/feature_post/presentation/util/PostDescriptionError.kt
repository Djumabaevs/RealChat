package com.djumabaevs.realchat.feature_post.presentation.util

sealed class PostDescriptionError : Error() {
    object FieldEmpty: PostDescriptionError()
}