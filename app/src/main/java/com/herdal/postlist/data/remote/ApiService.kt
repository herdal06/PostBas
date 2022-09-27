package com.herdal.postlist.data.remote

import com.herdal.postlist.data.remote.model.comment.CommentResponse
import com.herdal.postlist.data.remote.model.post.Post
import com.herdal.postlist.data.remote.model.post.PostResponse
import com.herdal.postlist.data.remote.model.user.User
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    // list all posts in home page
    @GET("posts")
    suspend fun getAllPosts(
        @Query("limit") limit: Int,
        @Query("skip") skip: Int
    ): PostResponse

    // for post details
    @GET("posts/{id}")
    suspend fun getPostById(@Path("id") id: Int): Post

    // list post's comments in post details
    @GET("posts/{id}/comments")
    suspend fun getPostComments(
        @Path("id") postId: Int,
        @Query("limit") limit: Int,
        @Query("skip") skip: Int
    ): CommentResponse

    // for user details
    @GET("users/{id}")
    suspend fun getUserById(@Path("id") id: Int): User

    // show user's posts in user details
    @GET("users/{userId}/posts")
    suspend fun getUserPosts(
        @Path("userId") userId: Int,
        @Query("limit") limit: Int,
        @Query("skip") skip: Int
    ): PostResponse
}