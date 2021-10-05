package com.djumabaevs.realchat.feature_profile.domain.use_case

import com.djumabaevs.realchat.core.util.Resource
import com.djumabaevs.realchat.feature_profile.domain.model.Skill
import com.djumabaevs.realchat.feature_profile.domain.repository.ProfileRepository

class GetSkillsUseCase(
    private val repository: ProfileRepository
) {

    suspend operator fun invoke(): Resource<List<Skill>> {
        return repository.getSkills()
    }
}