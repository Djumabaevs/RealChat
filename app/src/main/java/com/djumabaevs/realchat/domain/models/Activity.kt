package com.djumabaevs.realchat.domain.models

import com.djumabaevs.realchat.domain.util.ActivityAction

data class Activity(
    val username: String,
    val actionType: ActivityAction,
    val formattedTime: String
)
