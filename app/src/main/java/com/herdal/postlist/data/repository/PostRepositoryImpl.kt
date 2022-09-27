package com.herdal.postlist.data.repository

import com.herdal.postlist.data.remote.ApiService
import com.herdal.postlist.data.remote.model.post.Post
import com.herdal.postlist.data.remote.model.post.PostResponse
import com.herdal.postlist.domain.repository.PostRepository
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : PostRepository {
    override suspend fun getAllPosts(limit: Int, skip: Int): PostResponse =
        apiService.getAllPosts(limit, skip)

    override suspend fun getPostById(id: Int): Post = apiService.getPostById(id)

    override suspend fun getUserPosts(userId: Int, limit: Int, skip: Int): PostResponse =
        apiService.getUserPosts(userId, limit, skip)
}