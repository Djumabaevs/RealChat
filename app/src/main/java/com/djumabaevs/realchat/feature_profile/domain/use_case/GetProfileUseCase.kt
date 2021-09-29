package com.djumabaevs.realchat.feature_profile.domain.use_case

import com.djumabaevs.realchat.core.util.Resource
import com.djumabaevs.realchat.feature_profile.domain.model.Profile
import com.djumabaevs.realchat.feature_profile.domain.repository.ProfileRepository


class GetProfileUseCase(
    private val repository: ProfileRepository
) {

    suspend operator fun invoke(userId: String): Resource<Profile> {
        return repository.getProfile(userId)
    }
}