package com.sahibinden.hackathon.util

import com.sahibinden.hackathon.data.ResultWrapper
import java.io.IOException

suspend fun <T : Any> safeApiCall(call: suspend () -> ResultWrapper<T>, errorMessage: String): ResultWrapper<T> = try {
    call.invoke()
} catch (e: Exception) {
    ResultWrapper.Error(IOException(e.message, e))
}
