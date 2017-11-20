package com.egorzh.musikt.containers

import com.beust.klaxon.JsonObject
import com.beust.klaxon.array
import com.beust.klaxon.obj
import com.beust.klaxon.string
import com.egorzh.musikt.core.Resource

internal fun <T> JsonObject.relations(fieldName: String, factory: (Resource) -> (T)): List<Relation<T>>? =
        obj(fieldName)?.array<JsonObject>("data")?.map {
            Relation<T>(
                    it.string("id") ?: throw IllegalArgumentException("relation id not found"),
                    it.string("type") ?: throw IllegalArgumentException("type not found"),
                    factory
            )
        }
