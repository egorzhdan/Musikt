package com.egorzh.musikt.containers

import com.egorzh.musikt.core.Reference
import com.egorzh.musikt.core.Resource
import com.egorzh.musikt.networking.Request
import com.egorzh.musikt.networking.RequestFactory

/**
 * @author Egor Zhdan
 */
class Relation<out T> internal constructor(override val id: String,
                                           private val type: String,
                                           private var factory: (Resource) -> (T),
                                           private val requestFactory: RequestFactory = defaultRequestFactory) : Reference<T> {
    companion object {
        val defaultRequestFactory: RequestFactory = { Request(it) }
    }

    suspend override fun fetch(): T? {
        val res = requestFactory("$type/$id").handle()?.makeResource() ?: return null
        return factory(res)
    }
}