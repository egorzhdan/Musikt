package com.egorzh.musikt.networking

import java.net.HttpURLConnection
import java.net.URL
import kotlin.coroutines.experimental.suspendCoroutine

/**
 * Coroutines-based HTTP request
 *
 * @author Egor Zhdan
 */
internal class Request constructor(private val url: URL) {
    suspend fun send(): String {
        return suspendCoroutine { continuation ->
            val con = url.openConnection() as HttpURLConnection
            con.requestMethod = "GET"

            val code = con.responseCode
            if (code in 200..299) {
                continuation.resume(con.inputStream.bufferedReader().readText())
            } else {
                continuation.resumeWithException(RequestException(code))
            }
        }
    }
}