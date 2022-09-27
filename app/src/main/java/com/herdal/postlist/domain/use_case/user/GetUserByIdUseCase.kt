package com.herdal.postlist.domain.use_case.user

import com.herdal.postlist.data.remote.model.user.User
import com.herdal.postlist.domain.repository.UserRepository
import javax.inject.Inject

class GetUserByIdUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke(id: Int): User {
        return repository.getUserById(id)
    }
}