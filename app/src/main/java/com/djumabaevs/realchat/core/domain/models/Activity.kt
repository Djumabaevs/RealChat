package com.djumabaevs.realchat.core.domain.models

data class Activity(
    val username: String,
    val actionType: ActivityAction,
    val formattedTime: String,
)