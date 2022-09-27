package com.herdal.postlist.domain.repository

import com.herdal.postlist.data.remote.model.user.User

interface UserRepository {
    suspend fun getUserById(id: Int): User
}