package com.egorzh.musikt.containers

import com.beust.klaxon.JsonArray
import com.beust.klaxon.JsonObject
import com.beust.klaxon.array
import com.egorzh.musikt.core.Resource
import com.egorzh.musikt.networking.Request
import com.egorzh.musikt.networking.RequestException

internal suspend fun Request.handle(): JsonObject? = handleMultiple()?.firstOrNull()

internal suspend fun Request.handleMultiple(): JsonArray<JsonObject>? {
    try {
        return getJson().array<JsonObject>("data")
    } catch (e: RequestException) {
        if (e.isNotFound) return null
        throw e
    }
}

internal fun JsonObject.makeResource() = Resource(this)