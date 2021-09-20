package com.djumabaevs.realchat.feature_auth.domain.repository

interface AuthRepository {

    suspend fun register(
        email: String,
        username: String,
        password: String
    ): SimpleResource
}