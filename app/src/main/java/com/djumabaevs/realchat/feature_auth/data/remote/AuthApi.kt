package com.djumabaevs.realchat.feature_auth.data.remote

import com.djumabaevs.realchat.core.data.dto.response.BasicApiResponse
import com.djumabaevs.realchat.feature_auth.data.dto.request.CreateAccountRequest
import com.djumabaevs.realchat.feature_auth.data.dto.request.LoginRequest
import com.djumabaevs.realchat.feature_auth.data.dto.response.AuthResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthApi {

    @POST("/api/user/create")
    suspend fun register(
        @Body request: CreateAccountRequest
    ): BasicApiResponse<Unit>

    @POST("/api/user/login")
    suspend fun login(
        @Body request: LoginRequest
    ): BasicApiResponse<AuthResponse>

    @GET("/api/user/authenticate")
    suspend fun authenticate()

    companion object {
       // const val BASE_URL = "http://10.0.2.2:8001/"
        const val BASE_URL = "http://192.168.0.102:8001/"
    }
}