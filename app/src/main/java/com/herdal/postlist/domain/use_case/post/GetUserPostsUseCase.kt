package com.herdal.postlist.domain.use_case.post

import com.herdal.postlist.data.remote.model.post.PostResponse
import com.herdal.postlist.domain.repository.PostRepository
import javax.inject.Inject

class GetUserPostsUseCase @Inject constructor(
    private val repository: PostRepository
) {
    suspend operator fun invoke(userId: Int, limit: Int, skip: Int): PostResponse {
        return repository.getUserPosts(userId, limit, skip)
    }
}