package com.herdal.postlist.data.remote.model.post

import com.google.gson.annotations.SerializedName

data class Post(
    @SerializedName("body")
    val body: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("reactions")
    val reactions: Int,
    @SerializedName("tags")
    val tags: List<String>,
    @SerializedName("title")
    val title: String,
    @SerializedName("userId")
    val userId: Int
)