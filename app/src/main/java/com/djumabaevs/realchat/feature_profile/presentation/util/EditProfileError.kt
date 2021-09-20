package com.djumabaevs.realchat.feature_profile.presentation.util


sealed class EditProfileError : Error() {
    object FieldEmpty: EditProfileError()
}