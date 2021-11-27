package com.sahibinden.hackathon.data

sealed class ResultWrapper<out T: Any> {
    data class Success<out T : Any>(val data: T) : ResultWrapper<T>()
    data class Error(val exception: Exception) : ResultWrapper<Nothing>()
}

