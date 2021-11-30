package com.djumabaevs.realchat.core.domain.use_case

import com.djumabaevs.realchat.core.domain.repository.ProfileRepository
import com.djumabaevs.realchat.core.util.SimpleResource

class ToggleFollowStateForUserUseCase(
    private val repository: ProfileRepository
) {

    suspend operator fun invoke(userId: String, isFollowing: Boolean): SimpleResource {
        return if(isFollowing) {
            repository.unfollowUser(userId)
        } else {
            repository.followUser(userId)
        }
    }
}