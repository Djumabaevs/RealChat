package com.djumabaevs.realchat.feature_profile.domain.repository

import com.djumabaevs.realchat.core.util.Resource
import com.djumabaevs.realchat.feature_profile.domain.model.Profile

interface ProfileRepository {

    suspend fun getProfile(userId: String): Resource<Profile>
}