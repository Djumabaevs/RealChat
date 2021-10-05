package com.djumabaevs.realchat.feature_profile.domain.use_case

import android.net.Uri
import com.djumabaevs.realchat.R
import com.djumabaevs.realchat.core.util.Resource
import com.djumabaevs.realchat.core.util.SimpleResource
import com.djumabaevs.realchat.core.util.UiText
import com.djumabaevs.realchat.feature_profile.domain.model.UpdateProfileData
import com.djumabaevs.realchat.feature_profile.domain.repository.ProfileRepository

class UpdateProfileUseCase(
    private val repository: ProfileRepository
) {

    suspend operator fun invoke(
        updateProfileData: UpdateProfileData,
        profilePictureUri: Uri?,
        bannerUri: Uri?
    ): SimpleResource {
        if(updateProfileData.username.isBlank()) {
            return Resource.Error(
                uiText = UiText.StringResource(R.string.error_username_empty)
            )
        }
        return repository.updateProfile(
            updateProfileData = updateProfileData,
            profilePictureUri = profilePictureUri,
            bannerImageUri = bannerUri
        )
    }
}