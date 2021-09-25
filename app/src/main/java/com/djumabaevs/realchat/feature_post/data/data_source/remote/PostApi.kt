package com.djumabaevs.realchat.feature_post.data.data_source.remote

import com.djumabaevs.realchat.core.data.dto.response.BasicApiResponse
import com.djumabaevs.realchat.core.domain.models.Post
import okhttp3.MultipartBody
import retrofit2.http.*


interface PostApi {

    @GET("/api/post/get")
    suspend fun getPostsForFollows(
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int
    ): List<Post>

    @Multipart
    @POST("/api/post/create")
    suspend fun createPost(
        @Part postData: MultipartBody.Part,
        @Part postImage: MultipartBody.Part
    ): BasicApiResponse<Unit>

    companion object {
        const val BASE_URL = "http://10.0.2.2:8001/"
    }
}