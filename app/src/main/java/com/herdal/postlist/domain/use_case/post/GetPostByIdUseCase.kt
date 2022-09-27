package com.herdal.postlist.domain.use_case.post

import com.herdal.postlist.data.remote.model.post.Post
import com.herdal.postlist.domain.repository.PostRepository
import javax.inject.Inject

class GetPostByIdUseCase @Inject constructor(
    private val repository: PostRepository
) {
    suspend operator fun invoke(id: Int): Post {
        return repository.getPostById(id)
    }
}