package com.example.practiceflows

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface PostService {

    @GET("posts")
    fun getPosts(): Call<Posts>

    @GET("comments")
    fun getPosts(@Query("userId") userId: Int) : Call<Posts>

    @GET("posts")
    fun getPosts(@QueryMap key: Map<String, String>) : Call<Posts>

    @POST("posts")
    fun createPost(@Body post: Post): Call<Post>

    @PUT("posts/{id}")
    fun updatePost(@Path("id") id: Int, @Body post: Post): Call<Post>

    @DELETE("posts/{id}")
    fun deletePost(@Path("id") id: Int): Call<Post>
}