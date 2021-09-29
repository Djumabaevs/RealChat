package com.djumabaevs.realchat.feature_profile.presentation.profile

import com.djumabaevs.realchat.feature_profile.domain.model.Profile

data class ProfileState(
    val profile: Profile? = null,
    val isLoading: Boolean = false
)