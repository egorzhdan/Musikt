package com.egorzh.musikt.networking

/**
 * @author Egor Zhdan
 */
object Requests {
    val defaultFactory: RequestFactory = { Request(it) }

    fun artist(id: String, factory: RequestFactory = defaultFactory) =
            factory("artists/$id")

    fun artists(ids: Iterable<String>, factory: RequestFactory = defaultFactory) =
            factory("artists/${ids.joinToString(",")}")

    fun album(id: String, factory: RequestFactory = defaultFactory) =
            factory("albums/$id")

    fun albums(ids: Iterable<String>, factory: RequestFactory = defaultFactory) =
            factory("artists/${ids.joinToString(",")}")
}