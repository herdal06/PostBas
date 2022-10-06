package com.herdal.postlist.domain.use_case.post

import com.herdal.postlist.data.remote.model.post.PostResponse
import com.herdal.postlist.domain.repository.PostRepository
import com.herdal.postlist.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllPostsUseCase @Inject constructor(
    private val repository: PostRepository
) {
    operator fun invoke(limit: Int, skip: Int): Flow<Resource<PostResponse>> = flow {
        try {
            emit(Resource.Loading)
            val allPosts = repository.getAllPosts(limit, skip)
            emit(Resource.Success(allPosts))
        } catch (e: Exception) {
            emit(Resource.Error(e))
        }
    }
}