package com.herdal.postlist.data.remote.model.user

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("limit")
    val limit: Int,
    @SerializedName("skip")
    val skip: Int,
    @SerializedName("total")
    val total: Int,
    @SerializedName("users")
    val users: List<User>
)