package com.herdal.postlist.domain.repository

import com.herdal.postlist.data.remote.model.comment.CommentResponse

interface CommentRepository {
    suspend fun getPostComments(postId: Int, limit: Int, skip: Int): CommentResponse
}