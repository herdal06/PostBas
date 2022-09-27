package com.herdal.postlist.data.remote.model.comment

data class CommentResponse(
    val comments: List<Comment>,
    val limit: Int,
    val skip: Int,
    val total: Int
)