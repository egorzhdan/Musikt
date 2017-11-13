package com.egorzh.musikt.networking

/**
 * @author Egor Zhdan
 */
class RequestException(val code: Int): RuntimeException("HTTP error $code") {
    init {
        check(code != 200, { "cannot create an exception from 200 OK" })
    }

    val isNotFound = code == 404
}