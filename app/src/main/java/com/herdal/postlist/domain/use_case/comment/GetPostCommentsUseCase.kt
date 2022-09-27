package com.herdal.postlist.domain.use_case.comment

import com.herdal.postlist.data.remote.model.comment.CommentResponse
import com.herdal.postlist.domain.repository.CommentRepository
import javax.inject.Inject

class GetPostCommentsUseCase @Inject constructor(
    private val repository: CommentRepository
) {
    suspend operator fun invoke(postId: Int, limit: Int, skip: Int): CommentResponse {
        return repository.getPostComments(postId, limit, skip)
    }
}