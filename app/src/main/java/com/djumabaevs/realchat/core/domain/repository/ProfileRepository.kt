package com.djumabaevs.realchat.core.domain.repository

import android.net.Uri
import com.djumabaevs.realchat.core.domain.models.Post
import com.djumabaevs.realchat.core.domain.models.UserItem
import com.djumabaevs.realchat.core.util.Constants
import com.djumabaevs.realchat.core.util.Resource
import com.djumabaevs.realchat.core.util.SimpleResource
import com.djumabaevs.realchat.feature_profile.domain.model.Profile
import com.djumabaevs.realchat.feature_profile.domain.model.Skill
import com.djumabaevs.realchat.feature_profile.domain.model.UpdateProfileData

interface ProfileRepository {

    suspend fun getPostsPaged(
        page: Int = 0,
        pageSize: Int = Constants.DEFAULT_PAGE_SIZE,
        userId: String
    ): Resource<List<Post>>

    suspend fun getProfile(userId: String): Resource<Profile>

    suspend fun updateProfile(
        updateProfileData: UpdateProfileData,
        bannerImageUri: Uri?,
        profilePictureUri: Uri?
    ): SimpleResource

    suspend fun getSkills(): Resource<List<Skill>>

    suspend fun searchUser(query: String): Resource<List<UserItem>>

    suspend fun followUser(userId: String): SimpleResource

    suspend fun unfollowUser(userId: String): SimpleResource

    fun logout()
}