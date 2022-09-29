package com.herdal.postlist.data.remote.model.post

import com.google.gson.annotations.SerializedName

data class PostResponse(
    @SerializedName("limit")
    val limit: Int,
    @SerializedName("posts")
    val posts: List<Post>,
    @SerializedName("skip")
    val skip: Int,
    @SerializedName("total")
    val total: Int
)