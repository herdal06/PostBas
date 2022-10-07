package com.herdal.postlist.domain.use_case.comment

import com.herdal.postlist.data.remote.model.comment.CommentResponse
import com.herdal.postlist.domain.repository.CommentRepository
import com.herdal.postlist.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetPostCommentsUseCase @Inject constructor(
    private val repository: CommentRepository
) {
    operator fun invoke(
        postId: Int,
        limit: Int,
        skip: Int
    ): Flow<Resource<CommentResponse>> = flow {
        try {
            emit(Resource.Loading)
            val allPostComments = repository.getPostComments(postId, limit, skip)
            emit(Resource.Success(allPostComments))
        } catch (e: Exception) {
            emit(Resource.Error(e))
        }
    }
}