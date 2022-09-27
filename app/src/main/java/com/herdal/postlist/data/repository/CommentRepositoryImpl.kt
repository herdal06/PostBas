package com.herdal.postlist.data.repository

import com.herdal.postlist.data.remote.ApiService
import com.herdal.postlist.data.remote.model.comment.CommentResponse
import com.herdal.postlist.domain.repository.CommentRepository
import javax.inject.Inject

class CommentRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : CommentRepository {
    override suspend fun getPostComments(
        postId: Int,
        limit: Int,
        skip: Int
    ): CommentResponse = apiService.getPostComments(postId, limit, skip)
}