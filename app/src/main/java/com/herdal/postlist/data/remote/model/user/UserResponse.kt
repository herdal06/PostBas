package com.herdal.postlist.data.remote.model.user

data class UserResponse(
    val limit: Int,
    val skip: Int,
    val total: Int,
    val users: List<User>
)