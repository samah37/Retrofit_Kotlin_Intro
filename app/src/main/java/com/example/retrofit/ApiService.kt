package com.example.retrofit

import com.example.retrofit.models.Comment
import com.example.retrofit.models.Post
import com.example.retrofit.models.User
import retrofit2.Response
import retrofit2.http.*

/**In this interface, I'll put the methods with thier routes
 * NB: the type of response must be specified for each method
 * You can use all these methods: @GET @POST @PUT @DELETE @PATCH
 */

interface ApiService {
    @GET("users")
    suspend fun getUsers(): Response<MutableList<User>>

    @GET("posts/{num}")
    suspend fun getPostById(@Path("num") num : Int): Response<Post>

    @GET("comments")
    suspend fun getCommentsByPost(@Query("postId") postId : Int) : Response<MutableList<Comment>>

    @POST("posts")
    suspend fun createPost(@Body post : Post): Response <Post>
}