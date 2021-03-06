package com.djumabaevs.realchat.feature_auth.domain.use_case

import com.djumabaevs.realchat.core.util.SimpleResource
import com.djumabaevs.realchat.feature_auth.domain.repository.AuthRepository

class AuthenticateUseCase(
    private val repository: AuthRepository
) {

    suspend operator fun invoke(): SimpleResource {
        return repository.authenticate()
    }
}