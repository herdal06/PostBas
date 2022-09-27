package com.herdal.postlist.data.remote.model.comment

data class Comment(
    val body: String,
    val id: Int,
    val postId: Int,
    val user: User
)