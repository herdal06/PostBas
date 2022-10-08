package com.herdal.postlist.domain.use_case.post

import com.herdal.postlist.data.remote.model.post.Post
import com.herdal.postlist.domain.repository.PostRepository
import com.herdal.postlist.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetPostByIdUseCase @Inject constructor(
    private val repository: PostRepository
) {
    suspend operator fun invoke(id: Int): Flow<Resource<Post>> {
        return flow {
            val user = repository.getPostById(id)
            emit(Resource.Success(user))
        }.flowOn(Dispatchers.IO)
    }
}