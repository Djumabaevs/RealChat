package com.djumabaevs.realchat.core.domain.models

import com.djumabaevs.realchat.feature_activtiy.domain.ActivityAction

data class Activity(
    val userId: String,
    val parentId: String,
    val username: String,
    val activityType: ActivityType,
    val formattedTime: String,
)