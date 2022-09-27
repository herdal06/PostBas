package com.herdal.postlist.data.repository

import com.herdal.postlist.data.remote.ApiService
import com.herdal.postlist.data.remote.model.user.User
import com.herdal.postlist.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : UserRepository {
    override suspend fun getUserById(id: Int): User = apiService.getUserById(id)
}