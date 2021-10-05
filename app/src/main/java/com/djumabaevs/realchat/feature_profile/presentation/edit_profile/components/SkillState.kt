package com.djumabaevs.realchat.feature_profile.presentation.edit_profile.components

import com.djumabaevs.realchat.feature_profile.domain.model.Skill

data class SkillsState(
    val skills: List<Skill> = emptyList(),
    val selectedSkills: List<Skill> = emptyList()
)