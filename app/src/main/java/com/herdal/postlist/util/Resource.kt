package com.herdal.postlist.util

sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(val error: String) : Resource<T>()
    class Loading<T>(data: T? = null) : Resource<T>(data)
}