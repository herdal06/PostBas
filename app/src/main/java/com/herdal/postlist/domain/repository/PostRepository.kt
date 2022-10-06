package com.herdal.postlist.domain.repository

import com.herdal.postlist.data.remote.model.post.Post
import com.herdal.postlist.data.remote.model.post.PostResponse

interface PostRepository {
    suspend fun getAllPosts(limit: Int, skip: Int): PostResponse
    suspend fun getPostById(id: Int): Post
    suspend fun getUserPosts(userId: Int, limit: Int, skip: Int): PostResponse
}