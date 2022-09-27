package com.herdal.postlist.domain.use_case.post

import com.herdal.postlist.data.remote.model.post.PostResponse
import com.herdal.postlist.domain.repository.PostRepository
import javax.inject.Inject

class GetAllPostsUseCase @Inject constructor(
    private val repository: PostRepository
) {
    suspend operator fun invoke(limit: Int, skip: Int): PostResponse {
        return repository.getAllPosts(limit, skip)
    }
}