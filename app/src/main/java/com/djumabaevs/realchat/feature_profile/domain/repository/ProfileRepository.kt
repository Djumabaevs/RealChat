package com.djumabaevs.realchat.feature_profile.domain.repository

import android.net.Uri
import com.djumabaevs.realchat.core.util.Resource
import com.djumabaevs.realchat.core.util.SimpleResource
import com.djumabaevs.realchat.feature_profile.domain.model.Profile
import com.djumabaevs.realchat.feature_profile.domain.model.Skill
import com.djumabaevs.realchat.feature_profile.domain.model.UpdateProfileData

interface ProfileRepository {

    suspend fun getProfile(userId: String): Resource<Profile>

    suspend fun updateProfile(
        updateProfileData: UpdateProfileData,
        bannerImageUri: Uri?,
        profilePictureUri: Uri?
    ): SimpleResource

    suspend fun getSkills(): Resource<List<Skill>>
}