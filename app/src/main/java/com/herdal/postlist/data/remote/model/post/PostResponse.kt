package com.herdal.postlist.data.remote.model.post

data class PostResponse(
    val limit: Int,
    val posts: List<Post>,
    val skip: Int,
    val total: Int
)