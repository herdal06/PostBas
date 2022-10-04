package com.herdal.postlist.util

sealed class Resource<out T> {
    object Loading : Resource<Nothing>()
    object Nothing2 : Resource<Nothing>()
    data class Success<T>(val data: T) : Resource<T>()
    data class Error(val error: Throwable) : Resource<Nothing>()
}