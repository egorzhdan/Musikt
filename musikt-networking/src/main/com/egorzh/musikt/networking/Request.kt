package com.egorzh.musikt.networking

import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import kotlin.coroutines.experimental.*
import com.beust.klaxon.JsonObject
import com.beust.klaxon.Parser
import com.egorzh.musikt.networking.auth.Auth

/**
 * Coroutines-based Apple Music API HTTP request
 *
 * @author Egor Zhdan
 */
open class Request(private val url: URL) {
    companion object {
        var defaultStorefront = "us"
    }

    constructor(endpoint: String, storefront: String = defaultStorefront) :
            this(URL("https", "api.music.apple.com", "/v1/catalog/$storefront/$endpoint"))

    open suspend fun stream(): InputStream = suspendCoroutine { continuation ->
        Auth.generateJWT()
        val con = url.openConnection() as HttpURLConnection
        con.headerFields["Authorization"] = listOf("Bearer ${Auth.jwt}")
        con.requestMethod = "GET"

        val code = con.responseCode

        if (code in 200..299) {
            continuation.resume(con.inputStream)
        } else {
            continuation.resumeWithException(RequestException(code))
        }
    }

    suspend fun send() = stream().bufferedReader().readText()

    suspend fun getJson() = Parser().parse(stream()) as JsonObject
}
