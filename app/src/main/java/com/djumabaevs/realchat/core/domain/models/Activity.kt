package com.djumabaevs.realchat.core.domain.models

import com.djumabaevs.realchat.feature_activtiy.domain.ActivityAction

data class Activity(
    val username: String,
    val actionType: ActivityAction,
    val formattedTime: String,
)