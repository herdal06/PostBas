package com.herdal.postlist.domain.repository

import com.herdal.postlist.data.remote.model.post.Post
import com.herdal.postlist.data.remote.model.post.PostResponse
import kotlinx.coroutines.flow.Flow

interface PostRepository {
    fun getAllPosts(limit: Int, skip: Int): Flow<PostResponse>
    suspend fun getPostById(id: Int): Post
    suspend fun getUserPosts(userId: Int, limit: Int, skip: Int): PostResponse
}