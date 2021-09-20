package com.djumabaevs.realchat.feature_activtiy.domain

sealed class ActivityAction {
    object LikedPost : ActivityAction()
    object CommentedOnPost : ActivityAction()
    object FollowedYou : ActivityAction()
}
