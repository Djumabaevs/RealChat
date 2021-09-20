package com.djumabaevs.realchat.feature_auth.domain.models

import com.djumabaevs.realchat.core.util.SimpleResource
import com.djumabaevs.realchat.feature_auth.presentation.util.AuthError

data class RegisterResult(
    val emailError: AuthError? = null,
    val usernameError: AuthError? = null,
    val passwordError: AuthError? = null,
    val result: SimpleResource? = null
)