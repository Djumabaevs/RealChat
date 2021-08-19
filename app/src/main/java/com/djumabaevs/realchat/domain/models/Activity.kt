package com.djumabaevs.realchat.domain.models

data class Activity(
    val username: String,
    val activityType: ActivityAction,
    val formattedTime: String
)
